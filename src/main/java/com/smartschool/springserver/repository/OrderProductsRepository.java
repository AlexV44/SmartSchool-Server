package com.smartschool.springserver.repository;

import com.smartschool.springserver.model.OrderProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductsRepository extends CrudRepository<OrderProduct, Integer> {
}
