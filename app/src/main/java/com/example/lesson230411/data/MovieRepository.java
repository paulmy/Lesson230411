package com.example.lesson230411.data;

import android.content.Context;

import androidx.room.Room;

import com.example.lesson230411.data.model.MovieFullData;
import com.example.lesson230411.data.model.MovieShortData;
import com.example.lesson230411.data.model.MoviesListDto;
import com.example.lesson230411.utils.OnSearchComplete;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MovieRepository {
    private static final String API_KEY = "INPUT_API_KEY";


    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private final MovieApi api = retrofit.create(MovieApi.class);

    public void search(String request, OnSearchComplete<List<MovieShortData>> onSearchCompleteListener) {
        api.getMovies(API_KEY, request).enqueue(
                new Callback<MoviesListDto>() {
                    @Override
                    public void onResponse(Call<MoviesListDto> call, Response<MoviesListDto> response) {
                        MoviesListDto body = response.body();
                        if (response.isSuccessful() && body != null && body.getSearchResult()!=null) {
                            onSearchCompleteListener.onChangeState(body.getSearchResult());
                   } else {
                            onSearchCompleteListener.onChangeState( new ArrayList<>());
                       }

                    }

                    @Override
                    public void onFailure(Call<MoviesListDto> call, Throwable t) {

                    }
                });
    }

    public void getMovieById(String imdb, OnSearchComplete<MovieFullData> onSearchCompleteListener) {
        api.getMovieById(API_KEY, imdb, "full").enqueue(new Callback<MovieFullData>() {
            @Override
            public void onResponse(Call<MovieFullData> call, Response<MovieFullData> response) {
                MovieFullData body = response.body();
                if (response.isSuccessful() && body != null) {
                      onSearchCompleteListener.onChangeState(body);
                   // response.body();

                }
            }

            @Override
            public void onFailure(Call<MovieFullData> call, Throwable t) {

            }
        });

    }

}
