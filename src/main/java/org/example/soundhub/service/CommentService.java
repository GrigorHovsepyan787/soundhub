package org.example.soundhub.service;

import org.example.soundhub.model.Comment;
import org.example.soundhub.model.Performer;
import org.example.soundhub.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {

    Page<Performer> findBySong(Pageable pageable);

    Comment add(int songId, int userId, String commentText);

    Comment updateComment(int commentId, String commentText);

    void deleteById(int id);

    void likeComment(int id, int userId);

    void dislikeComment(int id, int userId);

    Performer getById(int id);

    Performer update(int id, Performer updatedPerformer);

    Page<Song> getSongsByPerformerId(int performerId, Pageable pageable);
}
