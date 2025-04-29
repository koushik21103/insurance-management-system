package com.insurance.insurance_management.repository;

import com.insurance.insurance_management.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
    // Custom agent queries if needed later
}
