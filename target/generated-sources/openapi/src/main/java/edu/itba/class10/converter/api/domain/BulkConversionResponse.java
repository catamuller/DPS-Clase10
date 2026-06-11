package edu.itba.class10.converter.api.domain;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import edu.itba.class10.converter.api.domain.ConvertedAmount;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * BulkConversionResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-11T14:38:46.369826200-03:00[America/Buenos_Aires]", comments = "Generator version: 7.13.0")
public class BulkConversionResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  @Valid
  private List<@Valid ConvertedAmount> results = new ArrayList<>();

  public BulkConversionResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public BulkConversionResponse(List<@Valid ConvertedAmount> results) {
    this.results = results;
  }

  public BulkConversionResponse results(List<@Valid ConvertedAmount> results) {
    this.results = results;
    return this;
  }

  public BulkConversionResponse addResultsItem(ConvertedAmount resultsItem) {
    if (this.results == null) {
      this.results = new ArrayList<>();
    }
    this.results.add(resultsItem);
    return this;
  }

  /**
   * Get results
   * @return results
   */
  @NotNull @Valid 
  @JsonProperty("results")
  public List<@Valid ConvertedAmount> getResults() {
    return results;
  }

  public void setResults(List<@Valid ConvertedAmount> results) {
    this.results = results;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BulkConversionResponse bulkConversionResponse = (BulkConversionResponse) o;
    return Objects.equals(this.results, bulkConversionResponse.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(results);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BulkConversionResponse {\n");
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
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

