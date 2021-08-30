package com.example.film.ui.fragments.film_list.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.film.data.model.Film;
import com.example.film.databinding.ItemListBinding;
import java.util.ArrayList;
import java.util.List;



public class ApiAdapter extends RecyclerView.Adapter<ApiAdapter.ViewHolder> {

    List<Film> list = new ArrayList<>();
    private Callback callback;
    private SaveRoom saveRoom;
    private ItemListBinding binding;

    public ApiAdapter(SaveRoom saveRoom) {
        this.saveRoom = saveRoom;
    }
    public ApiAdapter(Callback callback, SaveRoom saveRoom) {
        this.callback = callback;
        this.saveRoom = saveRoom;
    }

    public void setCallback(Callback callback) {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=ItemListBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,false);
        return new ViewHolder(binding,callback,saveRoom,binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ApiAdapter.ViewHolder holder, int position) {
     holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void addItems(List<Film>film){
        list.addAll(film);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ItemListBinding binding;
        private Callback callback;
        private SaveRoom saveRoom;


        public ViewHolder(ItemListBinding itemView,Callback callback, SaveRoom saveRoom, ItemListBinding binding) {
            super(itemView.getRoot());
            this.callback = callback;
            this.saveRoom = saveRoom;
            this.binding = binding;
        }

        public void onBind(Film film) {
            binding.title.setText(film.getTitle());
            binding.saveRoom.setOnClickListener(v -> saveRoom.click(film));
            binding.title.setOnClickListener(v -> {
                if (callback != null) {
                    callback.filmClick(film);
                }
            });
        }
    }
    public interface Callback {
        void filmClick(Film film);
    }

    public interface SaveRoom {
        void click(Film film);
    }
}
