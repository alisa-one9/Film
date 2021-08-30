package com.example.film.ui.fragments.film_detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.film.data.film.FilmStorage;
import com.example.film.data.model.Film;
import com.example.film.data.model.RetrofitB;
import com.example.film.databinding.FragmentFilmDetailBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FilmDetailFragment extends Fragment {

    private String filmId;
    private  final FilmStorage filmStorage =new FilmStorage();
    private FragmentFilmDetailBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            filmId = getArguments().getString("filmId");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentFilmDetailBinding.inflate(inflater,container,false);
        return binding.getRoot();

    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RetrofitB.getInstance().getFilmById(filmId).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if (response.isSuccessful() && response.body() !=null){
                    binding.infoTitle.setText(response.body().getTitle());
                    binding.infoJapanTitle.setText(response.body().getTitleJapan());
                    binding.infoDescription.setText(response.body().getDescF());

                }else {
                    Toast.makeText(requireActivity(), "Error!" +response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                Toast.makeText(requireActivity(), "Error"
                        +t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}