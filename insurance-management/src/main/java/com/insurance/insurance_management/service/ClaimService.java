package com.insurance.insurance_management.service;

import com.insurance.insurance_management.model.Claim;
import com.insurance.insurance_management.repository.ClaimRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClaimService {

    private final ClaimRepository claimRepository;

    public Claim save(Claim claim) {
        return claimRepository.save(claim);
    }

    public List<Claim> getAll() {
        return claimRepository.findAll();
    }

    public Optional<Claim> getById(Long id) {
        return claimRepository.findById(id);
    }

    public void delete(Long id) {
        claimRepository.deleteById(id);
    }
}

