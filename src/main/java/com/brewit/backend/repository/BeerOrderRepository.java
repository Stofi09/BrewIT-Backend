package com.brewit.backend.repository;

import com.brewit.backend.model.BeerOrder;
import org.springframework.data.repository.CrudRepository;

public interface BeerOrderRepository extends CrudRepository<BeerOrder,Long> {
}
