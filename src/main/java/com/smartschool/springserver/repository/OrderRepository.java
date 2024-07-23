package com.smartschool.springserver.repository;

import com.smartschool.springserver.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
    @Query("from Order o where o.school=:id")
    List<Order> findOrdersBySchoolId(@Param("id") int id);
}
