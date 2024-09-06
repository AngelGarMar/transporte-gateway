package com.transporte.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transporte.entities.User;

public interface AuthRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByUsernameAndEstatus(String username, int estatus);
}
