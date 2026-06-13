package edu.itba.class10.infrastructure.persistence;

import edu.itba.class10.IntegrationTest;
import edu.itba.class10.boot.Application;
import edu.itba.class10.domain.entity.money.Currency;
import edu.itba.class10.domain.entity.money.MoneyAmount;
import edu.itba.class10.domain.persistence.ExchangePersistence;
import edu.itba.class10.domain.persistence.SingleConversionEntity;
import edu.itba.class10.infrastructure.persistence.relational.SingleConversionSqlMapper;
import edu.itba.class10.infrastructure.persistence.relational.SqlExchangePersistence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.junit.jupiter.api.Assertions;
import org.springframework.test.context.ContextConfiguration;

import java.math.BigDecimal;
import java.time.LocalDate;

@DataJpaTest
@ActiveProfiles("sql")
@Import({
        SqlExchangePersistence.class,
        SingleConversionSqlMapper.class
})
@ContextConfiguration(classes = Application.class)
public class SqlExchangePersistenceIT extends IntegrationTest {
    @Autowired
    private ExchangePersistence exchangePersistence;

    @Test
    void findAllReturnsEmptyListWhenDatabaseIsEmpty() {
        final var result = exchangePersistence.findAll();

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    void savePersistsConversion() {

        final var conversion = new SingleConversionEntity(
                LocalDate.of(2025, 6, 13),
                MoneyAmount.create(Currency.EUR, BigDecimal.valueOf(100)),
                MoneyAmount.create(Currency.USD, BigDecimal.valueOf(10200))
        );

        exchangePersistence.save(conversion);

        final var result = exchangePersistence.findAll();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());

        final var saved = result.getFirst();

        Assertions.assertNotNull(saved);
        Assertions.assertEquals(LocalDate.of(2025, 6, 13), saved.date());

        Assertions.assertEquals(Currency.EUR, saved.from().currency());
        Assertions.assertEquals(0, BigDecimal.valueOf(100).compareTo(saved.from().amount()));

        Assertions.assertEquals(Currency.USD, saved.to().currency());
        Assertions.assertEquals(0, BigDecimal.valueOf(10200).compareTo(saved.to().amount()));
    }
}
