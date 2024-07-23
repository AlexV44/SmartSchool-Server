package com.smartschool.springserver.service;

import com.smartschool.springserver.dto.LoginDTO;
import com.smartschool.springserver.dto.SignupDTO;
import com.smartschool.springserver.dto.SmemberDTO;
import com.smartschool.springserver.mapper.SmemberMapper;
import com.smartschool.springserver.model.*;
import com.smartschool.springserver.repository.SchoolRepository;
import com.smartschool.springserver.repository.SmemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class SmemberService {
    @Autowired
    private SmemberRepository smemberRepository;
    @Autowired
    private SchoolRepository schoolRepository;

    public Smember save(Smember member) {
        return smemberRepository.save(member);
    }

    public void delete(int memberId) {
        smemberRepository.deleteById(memberId);
    }

    public List<Smember> getAllMembers() {
        ArrayList<Smember> members = new ArrayList<>();
        Streamable.of(smemberRepository.findAll())
                .forEach(members::add);
        return members;
    }

    public Smember signup(SignupDTO request) {
        School school = schoolRepository.findSchoolByIdentifier(request.getSchoolIdentifier());
        if (school == null) {
            throw new RuntimeException("Invalid school identifier!");
        }
        Smember member = mapMember(request);
        member.setSchool(school);
        return smemberRepository.save(member);
    }

    private Smember mapMember(SignupDTO request) {
        Smember member = new Smember();
        member.setName(request.getName());
        member.setEmail(request.getEmail());
        member.setRole(Role.USER);
        member.setBalance(100.);
        member.setPassword(Base64.getEncoder().encodeToString(
                request.getPassword().getBytes(StandardCharsets.UTF_8)
        ));
        return member;
    }

    public SmemberDTO login(LoginDTO request) {
        Smember member = getUserByEmail(request.getEmail());
        if(member == null) {
            throw new RuntimeException("Invalid Email!");
        }
        String inputPass = Base64.getEncoder().encodeToString(
                request.getPassword().getBytes(StandardCharsets.UTF_8));
        if(!inputPass.equals(member.getPassword())) {
            return null;
        }
        return SmemberMapper.mapSmember(member);
    }

    public Smember getUserByEmail(String email) {
        return smemberRepository.findUserByEmail(email);
    }

    public Smember setStaffById(int id) {
        Smember smember = smemberRepository.findById(id).get();
        if(smember.getRole().toString().equals("STAFF")) {
            return null;
        }
        smember.setRole(Role.STAFF);
        return smemberRepository.save(smember);
    }

    public double updateUserBalance(Smember smember) {
        Smember smember1 = smemberRepository.findById(smember.getId()).get();
        smember1.setBalance(smember.getBalance());
        smemberRepository.save(smember1);
        return smember1.getBalance();
    }

    public SmemberDTO getUserById(int id) {
        return SmemberMapper.mapSmember(smemberRepository.findById(id).get());
    }

    public Smember setTeacherById(int id) {
        Smember smember = smemberRepository.findById(id).get();
        if(smember.getRole().toString().equals("TEACHER")) {
            return null;
        }
        smember.setRole(Role.TEACHER);
        return smemberRepository.save(smember);
    }

    public Smember setElderById(int id) {
        Smember smember = smemberRepository.findById(id).get();
        if(smember.getRole().toString().equals("ELDER") || smember.getRole().toString().equals("DIRECTOR")
                || smember.getRole().toString().equals("STAFF")) {
            return null;
        }
        smember.setRole(Role.ELDER);
        return smemberRepository.save(smember);
    }
}
