package com.smartschool.springserver.repository;

import com.smartschool.springserver.model.Product;
import com.smartschool.springserver.model.SchoolProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Query("from SchoolProduct s where s.pk.school=:id")
    List<SchoolProduct> findProductsBySchoolId(@Param("id") int id);
}
