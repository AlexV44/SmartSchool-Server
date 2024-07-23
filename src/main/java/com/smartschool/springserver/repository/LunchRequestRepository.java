package com.smartschool.springserver.repository;

import com.smartschool.springserver.model.LunchRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LunchRequestRepository extends CrudRepository<LunchRequest, Integer> {
}
