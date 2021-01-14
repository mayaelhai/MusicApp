package com.example.musicapp.RoomPackage;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorites_data")
public class FavoritesData {

    public FavoritesData(String language, String where, String with, String mood, String why, String link) {
        this.language = language;
        this.where = where;
        this.with = with;
        this.mood = mood;
        this.why = why;
        this.link = link;
    }

    public FavoritesData() {

    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private long ID;

    @ColumnInfo(name = "language")
    private String language;

    @ColumnInfo(name = "where")
    private String where;

    @ColumnInfo(name = "with")
    private String with;

    @ColumnInfo(name = "mood")
    private String mood;

    @ColumnInfo(name = "why")
    private String why;

    @ColumnInfo(name = "link")
    private String link;


    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getWith() {
        return with;
    }

    public void setWith(String with) {
        this.with = with;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
