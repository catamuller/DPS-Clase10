package edu.itba.class10.infrastructure.persistence.relational;

import edu.itba.class10.domain.entity.money.Currency;
import edu.itba.class10.domain.entity.money.MoneyAmount;
import edu.itba.class10.domain.persistence.SingleConversionEntity;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

import java.sql.Timestamp;

@Component
public class SingleConversionSqlMapper {

	public SingleConversionSqlEntity toSql(SingleConversionEntity entity) {
		final var sqlEntity = new SingleConversionSqlEntity();
		sqlEntity.setDate(Timestamp.valueOf(entity.date().atStartOfDay()));
		sqlEntity.setFromCurrency(entity.from().currency().toString());
		sqlEntity.setFromAmount(entity.from().amount());
		sqlEntity.setToCurrency(entity.to().currency().toString());
		sqlEntity.setToAmount(entity.to().amount());
		return sqlEntity;
	}

    public SingleConversionEntity toEntity(final SingleConversionSqlEntity entity) {
        var from = MoneyAmount.create(Currency.valueOf(entity.getFromCurrency()), entity.getFromAmount());
        var to = MoneyAmount.create(Currency.valueOf(entity.getToCurrency()), entity.getToAmount());
        return new SingleConversionEntity(
                entity.getDate().toLocalDateTime().toLocalDate(),
                from,
                to
        );
    }
}
