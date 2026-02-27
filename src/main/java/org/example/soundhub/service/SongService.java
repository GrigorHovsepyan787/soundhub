package org.example.soundhub.service;

import org.example.soundhub.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SongService {

    Song uploadSong(Song song, MultipartFile file);

    Page<Song> findAll(Pageable pageable);

    Song getById(int id);

    Song updateSongTitle(int id, String newTitle);

    void deleteById(int id);

    List<Song> getSongsByAlbum(int albumId);

    Page<Song> getSongsByPerformer(int performerId, Pageable pageable);
}
