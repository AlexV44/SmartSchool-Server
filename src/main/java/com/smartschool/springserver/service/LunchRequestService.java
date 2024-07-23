package com.smartschool.springserver.service;

import com.smartschool.springserver.dto.LunchRequestDTO;
import com.smartschool.springserver.mapper.LunchRequestMapper;
import com.smartschool.springserver.model.LunchRequest;
import com.smartschool.springserver.model.School;
import com.smartschool.springserver.repository.LunchRequestRepository;
import com.smartschool.springserver.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LunchRequestService {
    @Autowired
    private LunchRequestRepository lunchRequestRepository;
    @Autowired
    private SchoolRepository schoolRepository;

    public LunchRequestDTO takeLunchRequest(LunchRequestDTO requestDTO) {
        LunchRequest lunchRequest = new LunchRequest();
        lunchRequest.setClassName(requestDTO.getClassName());
        lunchRequest.setStudentsQuantity(requestDTO.getStudentsQuantity());
        lunchRequest.setFreeStudentsQuantity(requestDTO.getFreeStudentsQuantity());
        lunchRequest.setRequestTime(requestDTO.getRequestTime());
        School school = schoolRepository.findById(requestDTO.getSchoolId()).get();
        lunchRequest.setSchool(school);
        lunchRequest = lunchRequestRepository.save(lunchRequest);
        return LunchRequestMapper.mapLunchRequest(lunchRequest);
    }
}
