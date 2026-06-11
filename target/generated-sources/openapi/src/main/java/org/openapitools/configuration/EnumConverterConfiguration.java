package org.openapitools.configuration;

import edu.itba.class10.converter.api.domain.Currency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration(value = "org.openapitools.configuration.enumConverterConfiguration")
public class EnumConverterConfiguration {

    @Bean(name = "org.openapitools.configuration.EnumConverterConfiguration.currencyConverter")
    Converter<String, Currency> currencyConverter() {
        return new Converter<String, Currency>() {
            @Override
            public Currency convert(String source) {
                return Currency.fromValue(source);
            }
        };
    }

}
