package com.example.model;

import java.util.List;

public class Song {
    private String name;
    private String singerName;
    private List<String> category;
    private String songURL;

    public Song() {
    }

    public Song(String name, String singerName, List<String> category, String songURL) {
        this.name = name;
        this.singerName = singerName;
        this.category = category;
        this.songURL = songURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public String getSongURL() {
        return songURL;
    }

    public void setSongURL(String songURL) {
        this.songURL = songURL;
    }
}
