package org.example.soundhub.service;

import org.example.soundhub.model.Performer;
import org.example.soundhub.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PerformerService {

    Page<Performer> findAll(Pageable pageable);

    Performer create(Performer performer);

    Performer getById(int id);

    Performer update(int id, Performer updatedPerformer);

    void deleteById(int id);

    Page<Song> getSongsByPerformerId(int performerId, Pageable pageable);
}
