package com.smartschool.springserver.controller;

import com.smartschool.springserver.dto.LunchRequestDTO;
import com.smartschool.springserver.service.LunchRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LunchRequestController {
    @Autowired
    private LunchRequestService lunchRequestService;

    @PostMapping(value = "/takelunchrequest", consumes = {"*/*"})
    public LunchRequestDTO takeLunchRequest(@RequestBody LunchRequestDTO lunchRequestDTO) {
        return lunchRequestService.takeLunchRequest(lunchRequestDTO);
    }
}
