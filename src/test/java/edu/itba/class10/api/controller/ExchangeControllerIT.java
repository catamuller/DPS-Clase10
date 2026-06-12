package edu.itba.class10.api.controller;

import edu.itba.class10.IntegrationTest;

import edu.itba.class10.boot.Application;
import edu.itba.class10.converter.api.domain.ConvertedAmount;
import edu.itba.class10.converter.api.domain.Currency;
import edu.itba.class10.converter.api.domain.SingleConversionRequest;
import edu.itba.class10.converter.api.domain.Conversion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("sql")
class ExchangeControllerIT extends IntegrationTest {

	@Autowired
	private TestRestTemplate testRestTemplate;


	@Test
	void convertsEurToUsdThroughHttpEndpoint() {
		var request = new SingleConversionRequest().from(Currency.EUR).amount(100.0).to(Currency.USD);
		var responsePost=this.testRestTemplate.postForEntity("/v1/exchange/conversion",request, ConvertedAmount.class);

		assertThat(responsePost.getStatusCode().value(), is(200));
		assertThat(responsePost.getBody().getCurrency().name(), is("USD"));
		assertThat(responsePost.getBody().getAmount(),is(10200.0));

		var responseGet=this.testRestTemplate.getForEntity("/v1/exchange/conversion",Conversion[].class);
		assertThat(responseGet.getStatusCode().value(), is(200));
		assertThat(responseGet.getBody()[0].getFrom().getCurrency().name(),is("EUR"));
		assertThat(responseGet.getBody()[0].getTo().getCurrency().name(), is("USD"));
		assertThat(responseGet.getBody()[0].getTo().getAmount(),is(10200.0));
	}
}
