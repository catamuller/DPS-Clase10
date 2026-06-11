package edu.itba.class10.converter.api.domain;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import edu.itba.class10.converter.api.domain.ExchangeRateResponse;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * HistoricalRateResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-11T14:38:46.369826200-03:00[America/Buenos_Aires]", comments = "Generator version: 7.13.0")
public class HistoricalRateResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate date;

  private ExchangeRateResponse exchangeRateResponse;

  public HistoricalRateResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public HistoricalRateResponse(LocalDate date, ExchangeRateResponse exchangeRateResponse) {
    this.date = date;
    this.exchangeRateResponse = exchangeRateResponse;
  }

  public HistoricalRateResponse date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
   */
  @NotNull @Valid 
  @JsonProperty("date")
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public HistoricalRateResponse exchangeRateResponse(ExchangeRateResponse exchangeRateResponse) {
    this.exchangeRateResponse = exchangeRateResponse;
    return this;
  }

  /**
   * Get exchangeRateResponse
   * @return exchangeRateResponse
   */
  @NotNull @Valid 
  @JsonProperty("exchangeRateResponse")
  public ExchangeRateResponse getExchangeRateResponse() {
    return exchangeRateResponse;
  }

  public void setExchangeRateResponse(ExchangeRateResponse exchangeRateResponse) {
    this.exchangeRateResponse = exchangeRateResponse;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HistoricalRateResponse historicalRateResponse = (HistoricalRateResponse) o;
    return Objects.equals(this.date, historicalRateResponse.date) &&
        Objects.equals(this.exchangeRateResponse, historicalRateResponse.exchangeRateResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, exchangeRateResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HistoricalRateResponse {\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    exchangeRateResponse: ").append(toIndentedString(exchangeRateResponse)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

