package com.example.film.data.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

    @GET("/films")
    Call<List<Film>> getFilm();

    @GET("/films/{id}")
    Call<Film>getFilmById(
            @Path("id")String filmId
    );
}
