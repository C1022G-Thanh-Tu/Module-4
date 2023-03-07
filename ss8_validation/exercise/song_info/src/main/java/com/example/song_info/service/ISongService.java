package com.example.song_info.service;

import com.example.song_info.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void creatSong(Song song);
    Song findById(int id);
    void updateSong (Song song);
}
