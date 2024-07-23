package com.smartschool.springserver.controller;

import com.smartschool.springserver.dto.SchoolProductDTO;
import com.smartschool.springserver.model.SchoolProduct;
import com.smartschool.springserver.repository.SchoolProductRepository;
import com.smartschool.springserver.service.SchoolProductService;
import com.smartschool.springserver.service.SmemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolProductController {
    @Autowired
    SchoolProductService schoolProductService;

    @GetMapping("/schoolProducts/{id}/schoolProducts")
    public List<SchoolProductDTO> getSchoolProductsBySchoolId(@PathVariable int id) {
        return schoolProductService.getSchoolProductsBySchoolId(id);
    }
}
