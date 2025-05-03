package com.insurance.insurance_management.repository;

import com.insurance.insurance_management.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {
}
