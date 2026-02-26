package org.example.soundhub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "song")

public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private int duration;

    private int playCount;

    private LocalDateTime uploadDate;

    private String fileName;

    @PrePersist
    public void onPrePersist() {
        uploadDate = LocalDateTime.now();
    }

    @ManyToMany
    @JoinTable(
            name = "song_artist",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private List<Artist> artists;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToMany
    @JoinTable(
            name = "playlist_song",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "playlist_id")
    )
    private List<Playlist> playlists;

    @OneToMany(mappedBy = "song")
    private List<Comment> comments;
}
