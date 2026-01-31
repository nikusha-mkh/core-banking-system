package org.example.corebankingsystem.repository;


import org.example.corebankingsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Optional for defence system null pointer exceptions
    Optional<User> findByEmail(String email);
}
