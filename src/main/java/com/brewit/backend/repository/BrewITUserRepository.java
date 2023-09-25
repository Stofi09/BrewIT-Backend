package com.brewit.backend.repository;

import com.brewit.backend.model.BrewITUser;
import org.springframework.data.repository.CrudRepository;

public interface BrewITUserRepository extends CrudRepository<BrewITUser,Long> {
}
