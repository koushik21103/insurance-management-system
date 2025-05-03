package com.insurance.insurance_management.controller;

import com.insurance.insurance_management.model.Claim;
import com.insurance.insurance_management.service.ClaimService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/claims")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ClaimController {

    private final ClaimService claimService;

    @PostMapping
    public ResponseEntity<Claim> create(@RequestBody Claim claim) {
        return ResponseEntity.ok(claimService.save(claim));
    }

    @GetMapping
    public ResponseEntity<List<Claim>> getAll() {
        return ResponseEntity.ok(claimService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Claim> getById(@PathVariable Long id) {
        return claimService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Claim> update(@PathVariable Long id, @RequestBody Claim updated) {
        return claimService.getById(id)
                .map(existing -> {
                    existing.setClaimAmount(updated.getClaimAmount());
                    existing.setStatus(updated.getStatus());
                    existing.setPolicy(updated.getPolicy());
                    existing.setCustomer(updated.getCustomer());
                    return ResponseEntity.ok(claimService.save(existing));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        claimService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
