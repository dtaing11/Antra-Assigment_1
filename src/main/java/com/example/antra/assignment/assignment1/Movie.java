package com.example.antra.assignment.assignment1;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private Integer year;

    @JsonProperty("imdbID")
    private String imdbId;

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImdbId() {
        return imdbId;
    }
}
