package org.example.soundhub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String surname;

    @Column(nullable = true)
    private String nickname;

    private String bio;

    private String pictureName;

    @ManyToMany(mappedBy = "artists")
    private List<Song> songs;
}