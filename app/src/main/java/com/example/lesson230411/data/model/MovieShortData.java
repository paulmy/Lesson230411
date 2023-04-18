package com.example.lesson230411.data.model;

import com.google.gson.annotations.SerializedName;

public class MovieShortData {
    @SerializedName("imdbID")
    private final String id;
    @SerializedName("Year")
    private final String year;
    @SerializedName("Title")
    private final String title;
    @SerializedName("Poster")
    private final String poster;

    public MovieShortData(String id, String year, String title, String poster) {
        this.id = id;
        this.year = year;
        this.title = title;
        this.poster = poster;
    }

    public String getId() {
        return id;
    }

    public String getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }
}
