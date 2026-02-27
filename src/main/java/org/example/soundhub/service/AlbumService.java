package org.example.soundhub.service;

import org.example.soundhub.model.Album;
import org.example.soundhub.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface AlbumService {

    Page<Album> findAll(Pageable pageable);

    Album create(Album album);

    Album getById(int id);

    Album update(int id, String title, String artist, LocalDate releaseDate, String coverImageName, String coverImage);

    void deleteById(int id);

    Album addSongToAlbum(int albumId, int songId);

    Album removeSongFromAlbum(int albumId, int songId);

    Page<Album> findByArtistId(int artistId, Pageable pageable);
}
