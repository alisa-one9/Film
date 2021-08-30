package com.example.film.frameworks.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.film.data.model.Film;

import java.util.List;

@Dao
public interface FilmDao {

    @Query("SELECT * FROM Film")
    LiveData<List<Film>> getAll();

    @Insert
    void insert(Film film);
}
