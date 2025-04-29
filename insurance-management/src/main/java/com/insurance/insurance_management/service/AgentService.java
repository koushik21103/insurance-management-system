package com.insurance.insurance_management.service;

import com.insurance.insurance_management.model.Agent;
import com.insurance.insurance_management.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    public Agent saveAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    public Optional<Agent> getAgentById(Long id) {
        return agentRepository.findById(id);
    }

    public void deleteAgent(Long id) {
        agentRepository.deleteById(id);
    }
}
