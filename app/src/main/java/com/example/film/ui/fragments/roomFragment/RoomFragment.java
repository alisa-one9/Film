package com.example.film.ui.fragments.roomFragment;

import android.os.Bundle;

import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.film.App;
import com.example.film.R;
import com.example.film.data.model.Film;
import com.example.film.databinding.FragmentRoomBinding;
import com.example.film.ui.fragments.film_list.adapters.ApiAdapter;

import java.util.List;

public class RoomFragment extends Fragment implements ApiAdapter.SaveRoom {
    private FragmentRoomBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRoomBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        roomInit();

    }

    private void roomInit() {
        App.getAppDatabase().filmDao().getAll().observe(getViewLifecycleOwner(), new Observer<List<Film>>() {
            @Override
            public void onChanged(List<Film> films) {
                initRecycler(films);
            }
        });
    }

    private void initRecycler(List<Film> films) {
        ApiAdapter apiAdapter = new ApiAdapter(this);
        apiAdapter.addItems(films);
        binding.recyclerView.setAdapter(apiAdapter);


    }

    @Override
    public void click(Film film) {

    }
}