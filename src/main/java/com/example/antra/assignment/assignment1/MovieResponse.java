package com.example.antra.assignment.assignment1;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieResponse {

    @JsonProperty("total_pages")
    private int totalPages;

    private List<Movie> data;

    public int getTotalPages() {
        return totalPages;
    }

    public List<Movie> getData() {
        return data;
    }
}
