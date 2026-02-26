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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String surname;

    private String email;

    private String username;

    private String password;

    private String pictureName;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    private LocalDateTime registrationDate;

    @PrePersist
    public void onPrePersist() {
        registrationDate = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "user")
    private List<Playlist> playlists;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
}
