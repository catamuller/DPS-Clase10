package edu.itba.class10.api.controller;

import edu.itba.class10.converter.api.domain.Currency;
import edu.itba.class10.converter.api.domain.SingleConversionRequest;
import edu.itba.class10.domain.entity.money.MoneyAmount;
import edu.itba.class10.domain.persistence.SingleConversionEntity;
import edu.itba.class10.domain.usecases.exchangerate.CurrencyConversionsHistory;
import edu.itba.class10.domain.usecases.exchangerate.CurrencyConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExchangeControllerTest {

	@Mock
	private CurrencyConverter currencyConverter;

    @Mock
    private CurrencyConversionsHistory currencyConversionsHistory;

	@Test
	void testSingleRequest() {
		// Given
		final var requestedCurrency = edu.itba.class10.domain.entity.money.Currency.EUR;
		final var expectedAmount = MoneyAmount.create(requestedCurrency, BigDecimal.valueOf(87.0));
		final var requestedAmount = MoneyAmount.create(edu.itba.class10.domain.entity.money.Currency.USD,
				BigDecimal.valueOf(100));

		final var request = new SingleConversionRequest().to(Currency.EUR).from(Currency.USD).amount(100.0);
		final var controller = new ExchangeController(this.currencyConverter,  this.currencyConversionsHistory);

		when(this.currencyConverter.convert(requestedAmount, requestedCurrency)).thenReturn(expectedAmount);

		// When
		final var result = controller.convertToSingleCurrency(request);

		// Then
		Assertions.assertEquals(expectedAmount.amount().doubleValue(), result.getBody().getAmount());
		Assertions.assertEquals(expectedAmount.currency().name(), result.getBody().getCurrency().name());
	}

    @Test
    void testGetAllConversions() {
        // Given
        final var entity1 = new SingleConversionEntity(
                LocalDate.of(2026, 5, 1),
                MoneyAmount.create(edu.itba.class10.domain.entity.money.Currency.USD, BigDecimal.valueOf(100.0)),
                MoneyAmount.create(edu.itba.class10.domain.entity.money.Currency.EUR, BigDecimal.valueOf(87.0))
        );
        final var entity2 = new SingleConversionEntity(
                LocalDate.of(2026, 5, 2),
                MoneyAmount.create(edu.itba.class10.domain.entity.money.Currency.EUR, BigDecimal.valueOf(200.0)),
                MoneyAmount.create(edu.itba.class10.domain.entity.money.Currency.GBP, BigDecimal.valueOf(156.0))
        );

        final var controller = new ExchangeController(this.currencyConverter, this.currencyConversionsHistory);

        when(this.currencyConversionsHistory.getAllConversions()).thenReturn(List.of(entity1, entity2));

        // When
        final var result = controller.getAllConversions();

        // Then
        Assertions.assertEquals(2, result.getBody().size());

        final var first = result.getBody().get(0);
        Assertions.assertEquals(entity1.date(), first.getDate());
        Assertions.assertEquals(entity1.from().amount().doubleValue(), first.getFrom().getAmount());
        Assertions.assertEquals(entity1.from().currency().name(), first.getFrom().getCurrency().name());
        Assertions.assertEquals(entity1.to().amount().doubleValue(), first.getTo().getAmount());
        Assertions.assertEquals(entity1.to().currency().name(), first.getTo().getCurrency().name());

        final var second = result.getBody().get(1);
        Assertions.assertEquals(entity2.date(), second.getDate());
        Assertions.assertEquals(entity2.from().amount().doubleValue(), second.getFrom().getAmount());
        Assertions.assertEquals(entity2.from().currency().name(), second.getFrom().getCurrency().name());
        Assertions.assertEquals(entity2.to().amount().doubleValue(), second.getTo().getAmount());
        Assertions.assertEquals(entity2.to().currency().name(), second.getTo().getCurrency().name());
    }
}
