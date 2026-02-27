package org.example.soundhub.service;

import org.example.soundhub.model.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlbumService {

    Page<Album> findAll(Pageable pageable);

    Album create(Album album);

    Album getById(int id);

    Album update(int id, Album updatedAlbum);

    void deleteById(int id);

    Album addSongToAlbum(int albumId, int songId);

    Album removeSongFromAlbum(int albumId, int songId);

    Page<Album> findByPerformerId(int artistId, Pageable pageable);
}
