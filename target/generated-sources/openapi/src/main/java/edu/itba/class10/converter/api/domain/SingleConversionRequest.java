package edu.itba.class10.converter.api.domain;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import edu.itba.class10.converter.api.domain.Currency;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * SingleConversionRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-11T14:38:46.369826200-03:00[America/Buenos_Aires]", comments = "Generator version: 7.13.0")
public class SingleConversionRequest implements Serializable {

  private static final long serialVersionUID = 1L;

  private Currency from;

  private Currency to;

  private Double amount;

  public SingleConversionRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SingleConversionRequest(Currency from, Currency to, Double amount) {
    this.from = from;
    this.to = to;
    this.amount = amount;
  }

  public SingleConversionRequest from(Currency from) {
    this.from = from;
    return this;
  }

  /**
   * Get from
   * @return from
   */
  @NotNull @Valid 
  @JsonProperty("from")
  public Currency getFrom() {
    return from;
  }

  public void setFrom(Currency from) {
    this.from = from;
  }

  public SingleConversionRequest to(Currency to) {
    this.to = to;
    return this;
  }

  /**
   * Get to
   * @return to
   */
  @NotNull @Valid 
  @JsonProperty("to")
  public Currency getTo() {
    return to;
  }

  public void setTo(Currency to) {
    this.to = to;
  }

  public SingleConversionRequest amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
   */
  @NotNull 
  @JsonProperty("amount")
  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SingleConversionRequest singleConversionRequest = (SingleConversionRequest) o;
    return Objects.equals(this.from, singleConversionRequest.from) &&
        Objects.equals(this.to, singleConversionRequest.to) &&
        Objects.equals(this.amount, singleConversionRequest.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, to, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SingleConversionRequest {\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

