package com.example.service;

import com.example.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> listSong();
    void addSong (Song song);
}
