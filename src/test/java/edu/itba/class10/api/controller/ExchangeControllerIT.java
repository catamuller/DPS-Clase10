package edu.itba.class10.api.controller;

import edu.itba.class10.IntegrationTest;
import edu.itba.class10.boot.Application;
import edu.itba.class10.converter.api.domain.Conversion;
import edu.itba.class10.converter.api.domain.ConvertedAmount;
import edu.itba.class10.converter.api.domain.Currency;
import edu.itba.class10.converter.api.domain.SingleConversionRequest;
import edu.itba.class10.domain.persistence.ExchangePersistence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.is;

@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("sql")
class ExchangeControllerIT extends IntegrationTest {

	private static final String CONVERSION_PATH = "/v1/exchange/conversion";

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Autowired
	private ExchangePersistence exchangePersistence;

	@Test
	void getAllConversionsReturnsEmptyListWhenNoConversionWasMade() {
		final var response = this.getAllConversions();

		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		assertThat(response.getBody(), is(emptyArray()));
	}

	@Test
	void getAllConversionsReturnsSinglePersistedConversion() {
		this.convert(Currency.EUR, Currency.USD, 100.0);

		final var response = this.getAllConversions();

		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		assertThat(response.getBody(), is(arrayWithSize(1)));

		final var conversion = response.getBody()[0];
		assertThat(conversion.getFrom().getCurrency(), is(Currency.EUR));
		assertThat(conversion.getFrom().getAmount(), is(100.0));
		assertThat(conversion.getTo().getCurrency(), is(Currency.USD));
		assertThat(conversion.getTo().getAmount(), is(10200.0));
	}

	@Test
	void getAllConversionsReturnsMultiplePersistedConversions() {
		this.convert(Currency.EUR, Currency.USD, 100.0);
		this.convert(Currency.EUR, Currency.USD, 50.0);

		final var response = this.getAllConversions();

		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		assertThat(response.getBody(), is(arrayWithSize(2)));
	}

	@Test
	void returnsBadRequestWhenConvertingUnsupportedCurrency() {
		final var body = """
				{
				  "from": "XYZ",
				  "to": "USD",
				  "amount": 100
				}
				""";
		final var headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		final var response = this.testRestTemplate.postForEntity(CONVERSION_PATH, new HttpEntity<>(body, headers),
				String.class);

		assertThat(response.getStatusCode(), is(HttpStatus.BAD_REQUEST));
	}

	private ResponseEntity<ConvertedAmount> convert(final Currency from, final Currency to, final double amount) {
		final var request = new SingleConversionRequest().from(from).to(to).amount(amount);
		return this.testRestTemplate.postForEntity(CONVERSION_PATH, request, ConvertedAmount.class);
	}

	private ResponseEntity<Conversion[]> getAllConversions() {
		return this.testRestTemplate.getForEntity(CONVERSION_PATH, Conversion[].class);
	}
}
