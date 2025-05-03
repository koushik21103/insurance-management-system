package com.insurance.insurance_management.service;

import com.insurance.insurance_management.model.Policy;
import com.insurance.insurance_management.repository.PolicyRepository;

import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PolicyService {

    private final PolicyRepository policyRepository;

    public Policy save(Policy policy) {
        return policyRepository.save(policy);
    }

    public List<Policy> getAll() {
        return policyRepository.findAll();
    }

    public Optional<Policy> getById(Long id) {
        return policyRepository.findById(id);
    }

    public void delete(Long id) {
        policyRepository.deleteById(id);
    }
}

