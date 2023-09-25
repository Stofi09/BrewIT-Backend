package com.brewit.backend.repository;

import com.brewit.backend.model.Beer;
import org.springframework.data.repository.CrudRepository;

public interface BeerRepository extends CrudRepository<Beer,Long> {
}
