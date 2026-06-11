package edu.itba.class10.infrastructure.persistence.data;

import edu.itba.class10.domain.entity.money.Currency;
import edu.itba.class10.domain.entity.money.MoneyAmount;
import edu.itba.class10.domain.persistence.SingleConversionEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class SingleConversionDataMapper {
	public SingleConversionDocument toDocument(SingleConversionEntity entity) {
		return new SingleConversionDocument(null, entity.date().toString(), entity.from().currency().toString(),
				entity.to().currency().toString(), entity.from().amount().doubleValue(),
				entity.to().amount().doubleValue());
	}

    public SingleConversionEntity toEntity(final SingleConversionDocument document) {
        var from = MoneyAmount.create(Currency.valueOf(document.getBaseCurrency()), document.getOriginalAmount());
        var to = MoneyAmount.create(Currency.valueOf(document.getTargetCurrency()), document.getConvertedAmount());
        return  new SingleConversionEntity(
                LocalDate.parse(document.getDate()),
                from,
                to
        );
    }
}
