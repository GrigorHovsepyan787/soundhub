package org.example.soundhub.service;

import org.example.soundhub.model.Playlist;
import org.example.soundhub.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PlaylistService {

    Page<Playlist> findPublicPlaylists(Pageable pageable);

    Page<Playlist> getPlaylistsByUserId(int userId, Pageable pageable);

    Playlist create(Playlist playlist);

    Playlist getById(int id);

    Playlist update(int id, Playlist updatedPlaylist);

    void deleteById(int id);

    Playlist addSongToPlaylist(int playlistId, int songId);

    Playlist removeSongFromPlaylist(int playlistId, int songId);

    Page<Song> getPlaylistSongs(int playlistId, Pageable pageable);
}
