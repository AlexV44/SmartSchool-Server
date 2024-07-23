package com.smartschool.springserver.service;

import com.smartschool.springserver.dto.SchoolProductDTO;
import com.smartschool.springserver.mapper.SchoolProductMapper;
import com.smartschool.springserver.model.School;
import com.smartschool.springserver.repository.SchoolProductRepository;
import com.smartschool.springserver.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolProductService {
    @Autowired
    private SchoolProductRepository schoolProductRepository;
    @Autowired
    private SchoolRepository schoolRepository;

    public List<SchoolProductDTO> getSchoolProductsBySchoolId(int schoolId) {
        Optional<School> school = schoolRepository.findById(schoolId);
        return school.map(value -> value.getSchoolProducts().stream().map(SchoolProductMapper::mapSchoolProduct).toList()).orElse(null);
    }
}
