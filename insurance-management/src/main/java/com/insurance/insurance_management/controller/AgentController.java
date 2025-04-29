package com.insurance.insurance_management.controller;

import com.insurance.insurance_management.model.Agent;
import com.insurance.insurance_management.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agents")
@CrossOrigin(origins = "http://localhost:3000")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @PostMapping
    public ResponseEntity<Agent> createAgent(@RequestBody Agent agent) {
        Agent savedAgent = agentService.saveAgent(agent);
        return ResponseEntity.ok(savedAgent);
    }

    @GetMapping
    public ResponseEntity<List<Agent>> getAllAgents() {
        return ResponseEntity.ok(agentService.getAllAgents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agent> getAgentById(@PathVariable Long id) {
        return agentService.getAgentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agent> updateAgent(@PathVariable Long id, @RequestBody Agent updatedAgent) {
        return agentService.getAgentById(id)
                .map(existingAgent -> {
                    existingAgent.setName(updatedAgent.getName());
                    existingAgent.setContactInfo(updatedAgent.getContactInfo());
                    Agent saved = agentService.saveAgent(existingAgent);
                    return ResponseEntity.ok(saved);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgent(@PathVariable Long id) {
        agentService.deleteAgent(id);
        return ResponseEntity.noContent().build();
    }
}
