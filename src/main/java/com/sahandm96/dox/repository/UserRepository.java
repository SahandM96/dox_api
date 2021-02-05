package com.sahandm96.dox.repository;

import com.sahandm96.dox.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);

    User findByEmail(String email);
    User findByCellPhoneNumber(String CellPhone);
    boolean existsByUsername(String username);
    boolean existsByEmail(String username);
}
