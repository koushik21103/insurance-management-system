package com.insurance.insurance_management.controller;

import com.insurance.insurance_management.model.Claim;
import com.insurance.insurance_management.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
@CrossOrigin(origins = "http://localhost:3000")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @PostMapping
    public ResponseEntity<Claim> createClaim(@RequestBody Claim claim) {
        Claim savedClaim = claimService.saveClaim(claim);
        return ResponseEntity.ok(savedClaim);
    }

    @GetMapping
    public ResponseEntity<List<Claim>> getAllClaims() {
        return ResponseEntity.ok(claimService.getAllClaims());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Claim> getClaimById(@PathVariable Long id) {
        return claimService.getClaimById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Claim> updateClaim(@PathVariable Long id, @RequestBody Claim updatedClaim) {
        return claimService.getClaimById(id)
                .map(existingClaim -> {
                    existingClaim.setPolicyId(updatedClaim.getPolicyId());
                    existingClaim.setCustomerId(updatedClaim.getCustomerId());
                    existingClaim.setClaimAmount(updatedClaim.getClaimAmount());
                    existingClaim.setStatus(updatedClaim.getStatus());
                    Claim saved = claimService.saveClaim(existingClaim);
                    return ResponseEntity.ok(saved);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClaim(@PathVariable Long id) {
        claimService.deleteClaim(id);
        return ResponseEntity.noContent().build();
    }
}
