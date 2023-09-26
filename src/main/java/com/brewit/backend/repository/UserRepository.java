package com.brewit.backend.repository;

import com.brewit.backend.model.BrewITUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<BrewITUser, Long> {
    Optional<BrewITUser> findByNameIgnoreCase(String name);

    Optional<BrewITUser> findByEmail(String email);
}
