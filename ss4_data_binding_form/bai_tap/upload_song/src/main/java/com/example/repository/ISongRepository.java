package com.example.repository;

import com.example.model.Song;

import java.util.List;

public interface ISongRepository {
    List<Song> listSong();
    void addSong (Song song);
}
