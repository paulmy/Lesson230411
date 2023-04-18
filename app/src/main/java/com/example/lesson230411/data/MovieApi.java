package com.example.lesson230411.data;

import com.example.lesson230411.data.model.MovieFullData;
import com.example.lesson230411.data.model.MoviesListDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface MovieApi {
    @GET("/")
    Call<MoviesListDto> getMovies(
            @Query("apikey") String apiKey,
            @Query("s") String searchRequest
    );
    @GET("/")
    Call<MovieFullData> getMovieById(
            @Query("apikey") String apiKey,
            @Query("i") String imdbId,
            @Query("plot") String plot

    );
}
