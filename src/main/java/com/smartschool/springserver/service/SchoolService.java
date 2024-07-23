package com.smartschool.springserver.service;

import com.smartschool.springserver.dto.LunchRequestDTO;
import com.smartschool.springserver.dto.OrderDTO;
import com.smartschool.springserver.dto.ProductDTO;
import com.smartschool.springserver.mapper.LunchRequestMapper;
import com.smartschool.springserver.mapper.OrderMapper;
import com.smartschool.springserver.mapper.ProductMapper;
import com.smartschool.springserver.model.School;
import com.smartschool.springserver.model.SchoolProduct;
import com.smartschool.springserver.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    public List<School> getAllSchools() {
        List<School> schools = new ArrayList<>();
        Streamable.of(schoolRepository.findAll()).forEach(schools::add);
        return schools;
    }

    public List<SchoolProduct> getProducts(String identifier) {
        School school = schoolRepository.findSchoolByIdentifier(identifier);
        if(school == null) {
            throw new RuntimeException("Error in products!");
        }
        return school.getSchoolProducts();
    }

    public School getSchoolByIdentifier(String identifier) {
       return schoolRepository.findSchoolByIdentifier(identifier);
    }

    public List<ProductDTO> getProductsBySchoolId(int id) {
        Optional<School> school = schoolRepository.findById(id);
        return school.map(value -> value.getSchoolProducts().stream().map(ProductMapper::mapProduct).toList()).orElse(null);
    }

    public List<OrderDTO> getOrdersBySchoolId(int id) {
        Optional<School> school = schoolRepository.findById(id);
        return school.map(value -> value.getOrders().stream().map(OrderMapper::mapOrder).toList()).orElse(null);
    }

    public List<LunchRequestDTO> getLunchRequestsBySchoolId(int id) {
        Optional<School> school = schoolRepository.findById(id);
        return school.map(value -> value.getLunchRequests().stream().map(LunchRequestMapper::mapLunchRequest).toList()).orElse(null);
    }
}
