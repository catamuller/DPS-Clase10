package edu.itba.class10.infrastructure.persistence.relational;

import edu.itba.class10.domain.persistence.ExchangePersistence;
import edu.itba.class10.domain.persistence.SingleConversionEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Profile("sql")
public class SqlExchangePersistence implements ExchangePersistence {

	private final SingleConversionSqlMapper singleConversionSqlMapper;
	private final SingleConversionJpaRepository singleConversionJpaRepository;

	@Override
	public void save(SingleConversionEntity entity) {
		final var sqlEntity = this.singleConversionSqlMapper.toSql(entity);
		this.singleConversionJpaRepository.save(sqlEntity);
	}

    @Override
    public List<SingleConversionEntity> findAll() {
        final var sqlEntityList = this.singleConversionJpaRepository.findAll();
        return sqlEntityList.stream().map(this.singleConversionSqlMapper::toEntity).toList();
    }
}
