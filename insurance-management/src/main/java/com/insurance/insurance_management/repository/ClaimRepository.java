package com.insurance.insurance_management.repository;

import com.insurance.insurance_management.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
    // Custom claim queries if needed later
}
