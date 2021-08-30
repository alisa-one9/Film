package com.example.film.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class Film {

    @PrimaryKey(autoGenerate = true)
    private long idRoom;

    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("original_title")
    private String titleJapan;

    @SerializedName("description")
    private String descF;

    public Film(String title, String titleJapan, String descF) {
        this.title = title;
        this.titleJapan = titleJapan;
        this.descF = descF;
    }

    public long getIdRoom() {
        return idRoom;
    }
    public String getId() {
        return id;
    }

    public void setIdRoom(long idRoom) {
        this.idRoom = idRoom;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleJapan() {
        return titleJapan;
    }

    public void setTitleJapan(String titleJapan) {
        this.titleJapan = titleJapan;
    }

    public String getDescF() {
        return descF;
    }

    public void setDescF(String descF) {
        this.descF = descF;
    }
}
