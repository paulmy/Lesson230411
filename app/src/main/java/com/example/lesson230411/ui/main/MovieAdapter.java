package com.example.lesson230411.ui.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson230411.data.model.MovieShortData;
import com.example.lesson230411.databinding.ItemMovieBinding;
import com.example.lesson230411.room.MovieData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<MovieShortData> items = new ArrayList<>();
private final  OnItemClick itemListener;

    public MovieAdapter(OnItemClick itemListener) {
        this.itemListener = itemListener;
    }

    public void setItems(List<MovieShortData> newItems) {
        items = newItems;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                ItemMovieBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemMovieBinding binding;
        public ViewHolder(@NonNull ItemMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(MovieShortData data) {
            binding.title.setText(data.getTitle());
            binding.year.setText(data.getYear());
            binding.getRoot().setOnClickListener(view->itemListener.onClick(data));
            Picasso.get().load(data.getPoster()).into(binding.poster);
        }
    }
    interface OnItemClick{
        void onClick(MovieShortData data);
    }
}
