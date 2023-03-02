package com.example.service.impl;

import com.example.model.Song;
import com.example.repository.ISongRepository;
import com.example.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    ISongRepository songRepository;

    @Override
    public List<Song> listSong() {
        return songRepository.listSong();
    }

    @Override
    public void addSong(Song song) {
        songRepository.addSong(song);
    }
}
