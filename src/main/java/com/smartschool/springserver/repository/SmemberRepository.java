package com.smartschool.springserver.repository;

import com.smartschool.springserver.model.Smember;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SmemberRepository extends CrudRepository<Smember, Integer> {
    @Query("from Smember sm where sm.email=:email")
    public Smember findUserByEmail(@Param("email") String email);
}
