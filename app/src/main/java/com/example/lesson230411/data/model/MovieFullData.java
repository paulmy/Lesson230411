package com.example.lesson230411.data.model;

import com.google.gson.annotations.SerializedName;

public class MovieFullData {
    @SerializedName("Title")
    private final String title;
    @SerializedName("Year")
    private final String yaer;
    @SerializedName("Rated")
    private final String rated;
    @SerializedName("Released")
    private final String released;
    @SerializedName("Genre")
    private final String genre;
    @SerializedName("Plot")
    private final String plot;
    @SerializedName("Poster")
    private final String poster;

    public MovieFullData(String title, String yaer, String rated, String released, String genre, String plot, String poster) {
        this.title = title;
        this.yaer = yaer;
        this.rated = rated;
        this.released = released;
        this.genre = genre;
        this.plot = plot;
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public String getYaer() {
        return yaer;
    }

    public String getRated() {
        return rated;
    }

    public String getReleased() {
        return released;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlot() {
        return plot;
    }

    public String getPoster() {
        return poster;
    }
}
