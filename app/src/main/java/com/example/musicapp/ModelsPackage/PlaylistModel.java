package com.example.musicapp.ModelsPackage;

public class PlaylistModel {

    private String language;
    private String where;
    private String with;
    private String mood;
    private String why;
    private String link;

    public PlaylistModel(String language, String where, String with, String mood, String why, String link) {
        this.language = language;
        this.where = where;
        this.with = with;
        this.mood = mood;
        this.why = why;
        this.link = link;
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
