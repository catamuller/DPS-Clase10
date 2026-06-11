package edu.itba.class10.api.controller.mapper;

import edu.itba.class10.converter.api.domain.Conversion;
import edu.itba.class10.converter.api.domain.ConvertedAmount;
import edu.itba.class10.converter.api.domain.SingleConversionRequest;
import edu.itba.class10.domain.entity.money.Currency;
import edu.itba.class10.domain.entity.money.MoneyAmount;
import edu.itba.class10.domain.persistence.SingleConversionEntity;

import java.math.BigDecimal;

public class SingleConversionMapper {
	public MoneyAmount toMoneyAmount(final SingleConversionRequest request) {
		return MoneyAmount.create(Currency.valueOf(request.getFrom().name()), BigDecimal.valueOf(request.getAmount()));
	}

	public Currency toCurrency(final SingleConversionRequest request) {
		return Currency.valueOf(request.getTo().name());
	}

	public ConvertedAmount toConvertedAmount(final MoneyAmount result) {
		return new ConvertedAmount()
				.currency(edu.itba.class10.converter.api.domain.Currency.valueOf(result.currency().name()))
				.amount(result.amount().doubleValue());
	}

    public Conversion toConversion(final SingleConversionEntity entity) {
        final var from = new edu.itba.class10.converter.api.domain.MoneyAmount()
                .currency(edu.itba.class10.converter.api.domain.Currency.valueOf(entity.from().currency().name()))
                .amount(entity.from().amount().doubleValue());

        final var to = new edu.itba.class10.converter.api.domain.MoneyAmount()
                .currency(edu.itba.class10.converter.api.domain.Currency.valueOf(entity.to().currency().name()))
                .amount(entity.to().amount().doubleValue());

        return new Conversion(entity.date(), from, to);
    }
}
