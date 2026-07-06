package com.app.rds.service;

import com.app.rds.entities.Policy;
import com.app.rds.exceptions.PolicyNotFoundException;
import com.app.rds.utility.CustomApiResponse;
import org.springframework.data.domain.Page;

public interface IPolicyService {

    CustomApiResponse createNewPolicy(Policy policy);

    Page<Policy> getPaginatedPolicies(Integer pageNumber, Integer pageSize);

    Policy getPolicyByPolicyId(Long policyId) throws PolicyNotFoundException;
}
