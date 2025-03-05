package com.microservice.user.repository;

import com.microservice.user.document.User;
import com.microservice.sharedmodel.core.repository.MongoQueryDSLRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoQueryDSLRepository<User> {
    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

}
