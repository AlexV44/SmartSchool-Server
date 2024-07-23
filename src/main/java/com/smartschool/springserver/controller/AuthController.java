package com.smartschool.springserver.controller;

import com.smartschool.springserver.dto.LoginDTO;
import com.smartschool.springserver.dto.SignupDTO;
import com.smartschool.springserver.dto.SmemberDTO;
import com.smartschool.springserver.model.Smember;
import com.smartschool.springserver.service.SmemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @Autowired
    SmemberService smemberService;

    @PostMapping("/signup")
    public Smember signup(@RequestBody SignupDTO request) {
        return smemberService.signup(request);
    }

    @PostMapping("/login")
    public SmemberDTO login(@RequestBody LoginDTO request) {
        return smemberService.login(request);
    }
}
