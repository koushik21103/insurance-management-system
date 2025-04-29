package com.insurance.insurance_management.controller;

import com.insurance.insurance_management.model.Policy;
import com.insurance.insurance_management.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
@CrossOrigin(origins = "http://localhost:3000")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @PostMapping
    public ResponseEntity<Policy> createPolicy(@RequestBody Policy policy) {
        Policy savedPolicy = policyService.savePolicy(policy);
        return ResponseEntity.ok(savedPolicy);
    }

    @GetMapping
    public ResponseEntity<List<Policy>> getAllPolicies() {
        return ResponseEntity.ok(policyService.getAllPolicies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Policy> getPolicyById(@PathVariable Long id) {
        return policyService.getPolicyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Policy> updatePolicy(@PathVariable Long id, @RequestBody Policy updatedPolicy) {
        return policyService.getPolicyById(id)
                .map(existingPolicy -> {
                    existingPolicy.setName(updatedPolicy.getName());
                    existingPolicy.setPremiumAmount(updatedPolicy.getPremiumAmount());
                    existingPolicy.setCoverageDetails(updatedPolicy.getCoverageDetails());
                    existingPolicy.setValidityPeriod(updatedPolicy.getValidityPeriod());
                    existingPolicy.setCustomerId(updatedPolicy.getCustomerId());
                    existingPolicy.setAgentId(updatedPolicy.getAgentId());
                    Policy saved = policyService.savePolicy(existingPolicy);
                    return ResponseEntity.ok(saved);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolicy(@PathVariable Long id) {
        policyService.deletePolicy(id);
        return ResponseEntity.noContent().build();
    }
}
