package com.smartschool.springserver.mapper;

import com.smartschool.springserver.dto.LunchRequestDTO;
import com.smartschool.springserver.model.LunchRequest;

public class LunchRequestMapper {
    public static LunchRequestDTO mapLunchRequest(LunchRequest lunchRequest) {
        LunchRequestDTO lunchRequestDTO = new LunchRequestDTO();
        lunchRequestDTO.setId(lunchRequest.getId());
        lunchRequestDTO.setClassName(lunchRequest.getClassName());
        lunchRequestDTO.setStudentsQuantity(lunchRequest.getStudentsQuantity());
        lunchRequestDTO.setFreeStudentsQuantity(lunchRequest.getFreeStudentsQuantity());
        lunchRequestDTO.setRequestTime(lunchRequest.getRequestTime());
        lunchRequestDTO.setSchoolId(lunchRequest.getSchool().getId());
        return lunchRequestDTO;
    }
}
