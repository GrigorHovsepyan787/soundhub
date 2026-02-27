package org.example.soundhub.service;

import org.example.soundhub.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface UserService {

    Page<User> findAll(Pageable pageable);

    User findById(int id);

    User save(User user, MultipartFile file);

    void deleteById(int id);

    Optional<User> findByUsername(String username);
}
