package com.insurance.insurance_management.service;

import com.insurance.insurance_management.model.Agent;
import com.insurance.insurance_management.repository.AgentRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AgentService {

    private final AgentRepository agentRepository;

    public Agent save(Agent agent) {
        return agentRepository.save(agent);
    }

    public List<Agent> getAll() {
        return agentRepository.findAll();
    }

    public Optional<Agent> getById(Long id) {
        return agentRepository.findById(id);
    }

    public void delete(Long id) {
        agentRepository.deleteById(id);
    }
}

