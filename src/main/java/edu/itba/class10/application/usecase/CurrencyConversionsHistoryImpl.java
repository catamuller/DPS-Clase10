package edu.itba.class10.application.usecase;

import edu.itba.class10.domain.persistence.ExchangePersistence;
import edu.itba.class10.domain.persistence.SingleConversionEntity;
import edu.itba.class10.domain.usecases.exchangerate.CurrencyConversionsHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyConversionsHistoryImpl implements CurrencyConversionsHistory {
    private final ExchangePersistence exchangePersistence;
    @Override
    public List<SingleConversionEntity> getAllConversions() {
        return exchangePersistence.findAll();
    }
}
