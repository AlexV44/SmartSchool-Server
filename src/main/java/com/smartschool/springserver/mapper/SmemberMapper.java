package com.smartschool.springserver.mapper;

import com.smartschool.springserver.dto.SmemberDTO;
import com.smartschool.springserver.model.Smember;

public class SmemberMapper {
    private SmemberMapper() {}

    public static SmemberDTO mapSmember(Smember member) {
        SmemberDTO smemberDTO = new SmemberDTO();
        smemberDTO.setId(member.getId());
        smemberDTO.setName(member.getName());
        smemberDTO.setEmail(member.getEmail());
        smemberDTO.setSchoolId(member.getSchool().getId());
        smemberDTO.setRole(member.getRole());
        smemberDTO.setBalance(member.getBalance());
        return smemberDTO;
    }
}
