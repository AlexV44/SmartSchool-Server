package com.smartschool.springserver.controller;

import com.smartschool.springserver.dto.LunchRequestDTO;
import com.smartschool.springserver.dto.OrderDTO;
import com.smartschool.springserver.dto.ProductDTO;
import com.smartschool.springserver.model.School;
import com.smartschool.springserver.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping("/api/schools")
    public List<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

    @GetMapping("/api/schools?identifier={identifier}")
    public School getSchool(@RequestParam("identifier") String identifier) {
        return schoolService.getSchoolByIdentifier(identifier);
    }

    @GetMapping("/api/schools/{id}/products")
    public List<ProductDTO> getProducts(@PathVariable int id) { //ok
        return schoolService.getProductsBySchoolId(id);
    }

    @GetMapping("/api/schools/{id}/orders")
    public List<OrderDTO> getOrders(@PathVariable int id) {
        return schoolService.getOrdersBySchoolId(id);
    }

    @GetMapping("/api/schools/{id}/lunchrequests")
    public List<LunchRequestDTO> getLunchRequests(@PathVariable int id) {
        return schoolService.getLunchRequestsBySchoolId(id);
    }
}
