package io.szugyi.nytimes.data.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "status",
        "copyright",
        "num_results",
        "results"
})
public class MostPopularApiResult {

    @JsonProperty("status")
    public String status;
    @JsonProperty("copyright")
    public String copyright;
    @JsonProperty("num_results")
    public Integer numResults;
    @JsonProperty("results")
    public List<Article> results = null;

    public String getStatus() {
        return status;
    }

    public String getCopyright() {
        return copyright;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public List<Article> getResults() {
        return results;
    }
}
