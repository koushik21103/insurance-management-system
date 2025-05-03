package com.insurance.insurance_management.controller;

import com.insurance.insurance_management.model.Policy;
import com.insurance.insurance_management.service.PolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/policies")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class PolicyController {

    private final PolicyService policyService;

    @PostMapping
    public ResponseEntity<Policy> create(@RequestBody Policy policy) {
        return ResponseEntity.ok(policyService.save(policy));
    }

    @GetMapping
    public ResponseEntity<List<Policy>> getAll() {
        return ResponseEntity.ok(policyService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Policy> getById(@PathVariable Long id) {
        return policyService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Policy> update(@PathVariable Long id, @RequestBody Policy updated) {
        return policyService.getById(id)
                .map(existing -> {
                    existing.setName(updated.getName());
                    existing.setPremiumAmount(updated.getPremiumAmount());
                    existing.setCoverageDetails(updated.getCoverageDetails());
                    existing.setValidityPeriod(updated.getValidityPeriod());
                    existing.setCustomer(updated.getCustomer());
                    existing.setAgent(updated.getAgent());
                    return ResponseEntity.ok(policyService.save(existing));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        policyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
