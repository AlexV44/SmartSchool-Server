package com.smartschool.springserver.repository;

import com.smartschool.springserver.model.SchoolProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolProductRepository extends CrudRepository<SchoolProduct, Integer> {
}
