package org.example.soundhub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
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
            name = "song_performer",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "performer_id")
    )
    private List<Performer> performers;

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
