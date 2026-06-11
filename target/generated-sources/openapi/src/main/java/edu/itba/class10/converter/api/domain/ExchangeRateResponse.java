package edu.itba.class10.converter.api.domain;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.HashMap;
import java.util.Map;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ExchangeRateResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-11T14:38:46.369826200-03:00[America/Buenos_Aires]", comments = "Generator version: 7.13.0")
public class ExchangeRateResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  @Valid
  private Map<String, Double> data = new HashMap<>();

  public ExchangeRateResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ExchangeRateResponse(Map<String, Double> data) {
    this.data = data;
  }

  public ExchangeRateResponse data(Map<String, Double> data) {
    this.data = data;
    return this;
  }

  public ExchangeRateResponse putDataItem(String key, Double dataItem) {
    if (this.data == null) {
      this.data = new HashMap<>();
    }
    this.data.put(key, dataItem);
    return this;
  }

  /**
   * Exchange rate values indexed by target currency code
   * @return data
   */
  @NotNull 
  @JsonProperty("data")
  public Map<String, Double> getData() {
    return data;
  }

  public void setData(Map<String, Double> data) {
    this.data = data;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExchangeRateResponse exchangeRateResponse = (ExchangeRateResponse) o;
    return Objects.equals(this.data, exchangeRateResponse.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExchangeRateResponse {\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

