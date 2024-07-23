package com.smartschool.springserver.repository;

import com.smartschool.springserver.model.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends CrudRepository<School, Integer> {
    @Query("from School s where s.identifier=:identifier")
    public School findSchoolByIdentifier(@Param("identifier") String identifier);
}
