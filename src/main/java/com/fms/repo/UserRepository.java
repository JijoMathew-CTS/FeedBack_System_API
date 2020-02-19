package com.fms.repo;


import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.entity.User;

/**
 * User repository for CRUD operations.
 */
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
