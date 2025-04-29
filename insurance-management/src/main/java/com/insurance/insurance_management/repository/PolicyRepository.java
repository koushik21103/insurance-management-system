package com.insurance.insurance_management.repository;

import com.insurance.insurance_management.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
    // Custom policy queries if needed later
}
