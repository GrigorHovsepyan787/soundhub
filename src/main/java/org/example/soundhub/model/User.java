package org.example.soundhub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
