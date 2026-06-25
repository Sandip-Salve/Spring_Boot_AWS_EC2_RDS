package com.app.rds.service;

import com.app.rds.entities.Policy;
import com.app.rds.respository.IPolicyRepository;
import com.app.rds.utility.CustomApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PolicyServiceImpl implements IPolicyService{

    private final Logger logger = LoggerFactory.getLogger(PolicyServiceImpl.class);

    @Autowired
    private IPolicyRepository policyRepository;

    @Override
    public CustomApiResponse createNewPolicy(Policy policy) {
        this.logger.info("Inside createNewPolicy method::{}",policy);
        Policy newPolicy = policyRepository.save(policy);
        String msg = "New policy created with ID::"+newPolicy.getPolicyId();
        return new CustomApiResponse(msg);
    }

    @Override
    public Page<Policy> getPaginatedPolicies(Integer pageNumber, Integer pageSize) {
        logger.info("Inside getPaginatedPolicies method, pageNumber::{}, pageSize::{}",pageNumber,pageSize);
        Pageable pageable = PageRequest.of(pageNumber,pageSize, Sort.by(Sort.Direction.ASC,"policyId"));
        Page<Policy> policyPage = policyRepository.findAll(pageable);
        return policyPage;
    }
}
