package com.example.film.data.film;

import android.util.Log;

import com.example.film.data.model.Film;
import com.example.film.data.model.RetrofitB;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmStorage {

    public void getFilm(String filmId, Callbacks<Film> callbacks) {
        RetrofitB.getInstance().getFilmById(filmId).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if (response.isSuccessful() && response.body() != null)
                    callbacks.success(response.body());
                else {
                    callbacks.failure("Status code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                callbacks.failure(t.getLocalizedMessage());
            }
        });
    }
    public interface Callbacks<Data> {
        void success(Data films);
        default void failure(String message) {
             Log.e("Callbacks", message);
        }


    }

}
