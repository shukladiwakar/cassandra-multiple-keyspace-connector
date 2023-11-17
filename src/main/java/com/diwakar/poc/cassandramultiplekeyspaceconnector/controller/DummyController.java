package com.diwakar.poc.cassandramultiplekeyspaceconnector.controller;

import com.diwakar.poc.cassandramultiplekeyspaceconnector.model.space1.Employee1;
import com.diwakar.poc.cassandramultiplekeyspaceconnector.model.space2.Employee2;
import com.diwakar.poc.cassandramultiplekeyspaceconnector.repo.space1.EmpSpace1Repo;
import com.diwakar.poc.cassandramultiplekeyspaceconnector.repo.space2.EmpSpace2Repo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class DummyController {

    @Autowired
    EmpSpace1Repo empSpace1Repo;
    @Autowired
    EmpSpace2Repo empSpace2Repo;

    @GetMapping(value = "/users")
    public void getUsersFrom2Keyspaces() throws JsonProcessingException {
        List<Employee1> list = empSpace1Repo.findAll();
        List<Employee2> list2 = empSpace2Repo.findAll();
        log.info("EMP from space1 {}", new ObjectMapper().writeValueAsString(list));
        log.info("EMP from space2 {}", new ObjectMapper().writeValueAsString(list2));
    }
}
