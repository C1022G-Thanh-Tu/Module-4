package com.example.repository.impl;

import com.example.model.Song;
import com.example.repository.ISongRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository implements ISongRepository {
    public static List<Song> songList;
    static {
        songList = new ArrayList<Song>() {{
            add(new Song("Đôi bờ", "DSK", new ArrayList<String>() {{
                add("rap");
                add("melody");
            }}, "https://www.youtube.com/watch?v=hF12jIJkPZA"));
            add(new Song("Im lặng", "LK", new ArrayList<String>() {{
                add("rap");
                add("melody");
            }}, "https://www.youtube.com/watch?v=8qJieZ_jD_c"));
        }};
    }

    @Override
    public List<Song> listSong() {
        return songList;
    }

    @Override
    public void addSong(Song song) {
        songList.add(song);
    }
}
