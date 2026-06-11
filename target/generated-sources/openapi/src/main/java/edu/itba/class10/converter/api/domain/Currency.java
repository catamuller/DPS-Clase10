package edu.itba.class10.converter.api.domain;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets Currency
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-11T14:38:46.369826200-03:00[America/Buenos_Aires]", comments = "Generator version: 7.13.0")
public enum Currency implements Serializable {
  
  EUR("EUR"),
  
  USD("USD"),
  
  JPY("JPY"),
  
  BGN("BGN"),
  
  CZK("CZK"),
  
  DKK("DKK"),
  
  GBP("GBP"),
  
  HUF("HUF"),
  
  PLN("PLN"),
  
  RON("RON"),
  
  SEK("SEK"),
  
  CHF("CHF"),
  
  ISK("ISK"),
  
  NOK("NOK"),
  
  HRK("HRK"),
  
  RUB("RUB"),
  
  TRY("TRY"),
  
  AUD("AUD"),
  
  BRL("BRL"),
  
  CAD("CAD"),
  
  CNY("CNY"),
  
  HKD("HKD"),
  
  IDR("IDR"),
  
  ILS("ILS"),
  
  INR("INR"),
  
  KRW("KRW"),
  
  MXN("MXN"),
  
  MYR("MYR"),
  
  NZD("NZD"),
  
  PHP("PHP"),
  
  SGD("SGD"),
  
  THB("THB"),
  
  ZAR("ZAR");

  private final String value;

  Currency(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Currency fromValue(String value) {
    for (Currency b : Currency.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

