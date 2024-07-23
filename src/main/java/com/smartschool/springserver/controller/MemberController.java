package com.smartschool.springserver.controller;

import com.smartschool.springserver.dto.SmemberDTO;
import com.smartschool.springserver.model.Smember;
import com.smartschool.springserver.service.SmemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {
    @Autowired
    private SmemberService service;

    @GetMapping("/member/get-all")
    public List<Smember> getAllMembers() {
        return service.getAllMembers();
    }

    @PostMapping("/member/save")
    public Smember save(@RequestBody Smember member) {
        return service.save(member);
    }

    @PostMapping("/member/setstaff")
    public Smember setStaffById(@RequestBody int id) {
        return service.setStaffById(id);
    }

    @PostMapping("/member/setbalance")
    public double setUserBalance(@RequestBody Smember smember) {
       return service.updateUserBalance(smember);
    }

    @PostMapping("/getuser")
    public SmemberDTO getUserById(@RequestBody int id) {
        return service.getUserById(id);
    }

    @PostMapping("/member/setteacher")
    public Smember setTeacherById(@RequestBody int id) {
        return service.setTeacherById(id);
    }

    @PostMapping("/member/setelder")
    public Smember setElderById(@RequestBody int id) {
        return service.setElderById(id);
    }
}
