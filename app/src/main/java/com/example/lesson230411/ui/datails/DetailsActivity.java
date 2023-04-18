package com.example.lesson230411.ui.datails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.lesson230411.data.MovieRepository;
import com.example.lesson230411.databinding.ActivityDetailsBinding;
import com.squareup.picasso.Picasso;


public class DetailsActivity extends AppCompatActivity {
    private static final String ID_ARG = "ID_ARG";
    private ActivityDetailsBinding binding;

    private final MovieRepository repository = new MovieRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String id = getIntent().getStringExtra(ID_ARG);
        repository.getMovieById(id, data -> {
            binding.plot.setText(data.getPlot());
            binding.title.setText(data.getTitle());
            binding.year.setText(data.getYaer());
            binding.rating.setText(data.getRated());
            binding.release.setText(data.getReleased());
            binding.genre.setText(data.getGenre());
            Picasso.get().load(data.getPoster()).into(binding.poster);
        });

    }

    public static Intent newIntent(Context context,String imdbId) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(ID_ARG, imdbId);
        return intent;
    }
}