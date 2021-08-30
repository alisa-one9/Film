package com.example.film.frameworks.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.film.data.model.Film;
import com.example.film.frameworks.dao.FilmDao;
@Database(entities = {Film.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract FilmDao filmDao();
}
