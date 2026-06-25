package com.app.rds.controller;

import com.app.rds.entities.Policy;
import com.app.rds.service.IPolicyService;
import com.app.rds.utility.CustomApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    private final Logger logger = LoggerFactory.getLogger(PolicyController.class);

    @Autowired
    private IPolicyService policyService;

    @PostMapping("/create")
    public ResponseEntity<CustomApiResponse> createNewPolicy(@RequestBody Policy policy){
        logger.info("Inside PolicyController's createNewPolicy method::{}",policy);
        CustomApiResponse customApiResponse = policyService.createNewPolicy(policy);
        return new ResponseEntity<>(customApiResponse, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Page<Policy>> getPaginatedPolicies(@RequestParam("pageNumber") Integer pageNumber,
                                                             @RequestParam("pageSize") Integer pageSize){
        Page<Policy> policyPage = policyService.getPaginatedPolicies(pageNumber,pageSize);
        return new ResponseEntity<>(policyPage,HttpStatus.OK);
    }
}
