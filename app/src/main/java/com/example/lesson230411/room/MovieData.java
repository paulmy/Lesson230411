package com.example.lesson230411.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

@Entity
public class MovieData {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "imdbID")
    private long id;

    public long getId() {
        return id;
    }

    @ColumnInfo(name = "Title")
    private  String title;

    @ColumnInfo(name="Year")
    private String yaer;

    @ColumnInfo(name="Rated")
    private  String rated;
    @ColumnInfo(name="Released")
    private String released;
    @ColumnInfo(name="Genre")
    private  String genre;
    @ColumnInfo(name="Plot")
    private  String plot;
    @ColumnInfo(name="Poster")
    private  String poster;

    public MovieData(long id, String title, String yaer, String rated, String released, String genre, String plot, String poster) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieData movieData = (MovieData) o;
        return id == movieData.id && Objects.equals(title, movieData.title) && Objects.equals(yaer, movieData.yaer) && Objects.equals(rated, movieData.rated) && Objects.equals(released, movieData.released) && Objects.equals(genre, movieData.genre) && Objects.equals(plot, movieData.plot) && Objects.equals(poster, movieData.poster);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, yaer, rated, released, genre, plot, poster);
    }
}


