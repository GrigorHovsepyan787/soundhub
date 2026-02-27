package org.example.soundhub.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "artist")
public class Artist extends Performer{

    private String surname;

    @Column(nullable = true)
    private String nickname;

    LocalDate birthdate;
}