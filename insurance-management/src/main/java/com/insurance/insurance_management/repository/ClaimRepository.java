package com.insurance.insurance_management.repository;

import com.insurance.insurance_management.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
}
