package com.insurance.insurance_management.repository;

import com.insurance.insurance_management.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
}
