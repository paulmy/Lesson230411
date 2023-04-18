package com.example.lesson230411.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.lesson230411.data.MovieRepository;
import com.example.lesson230411.databinding.ActivityMainBinding;
import com.example.lesson230411.ui.datails.DetailsActivity;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final MovieAdapter adapter = new MovieAdapter(data -> startActivity(DetailsActivity.newIntent(MainActivity.this, data.getId())));
    private MovieRepository repository = null;

    public MainActivity() {
        if (repository == null)
            repository = new MovieRepository();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.recycler.setAdapter(adapter);
        binding.search.setOnClickListener(v -> {
            goSearch();

        });
    }

  /*  private void onUpdateData(OnLoadingMovieState.State.Success state) {
        adapter.setItems(state.getMovies());
    }*/

    private void goSearch() {
        String searchRequest = binding.search.getText().toString();
        repository.search(searchRequest, data -> adapter.setItems(data));
    }

  /*  @Override
    protected void onDestroy() {
        super.onDestroy();
        repository.removeOnLoadingMovieState();
    }*/
}