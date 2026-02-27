package org.example.soundhub.repository;

import org.example.soundhub.model.Performer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformerRepository extends JpaRepository<Performer, Integer> {
}
