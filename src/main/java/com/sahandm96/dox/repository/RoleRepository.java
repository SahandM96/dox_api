package com.sahandm96.dox.repository;

import com.sahandm96.dox.domain.ERole;
import com.sahandm96.dox.domain.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole Name);
}
