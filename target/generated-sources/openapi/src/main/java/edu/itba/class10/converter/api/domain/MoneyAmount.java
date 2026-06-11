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
 * MoneyAmount
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-11T14:38:46.369826200-03:00[America/Buenos_Aires]", comments = "Generator version: 7.13.0")
public class MoneyAmount implements Serializable {

  private static final long serialVersionUID = 1L;

  private Currency currency;

  private Double amount;

  public MoneyAmount() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public MoneyAmount(Currency currency, Double amount) {
    this.currency = currency;
    this.amount = amount;
  }

  public MoneyAmount currency(Currency currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
   */
  @NotNull @Valid 
  @JsonProperty("currency")
  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  public MoneyAmount amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Monetary amount rounded to 2 decimals
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
    MoneyAmount moneyAmount = (MoneyAmount) o;
    return Objects.equals(this.currency, moneyAmount.currency) &&
        Objects.equals(this.amount, moneyAmount.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currency, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MoneyAmount {\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
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

