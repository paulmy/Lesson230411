package com.example.lesson230411.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesListDto {
    @SerializedName("Search")
    private final List<MovieShortData> searchResult;

    public MoviesListDto(List<MovieShortData> searchResult) {
        this.searchResult = searchResult;
    }

    public List<MovieShortData> getSearchResult() {
        return searchResult;
    }
}
