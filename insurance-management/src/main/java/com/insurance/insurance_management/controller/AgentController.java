package com.insurance.insurance_management.controller;

import com.insurance.insurance_management.model.Agent;
import com.insurance.insurance_management.service.AgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/agents")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AgentController {

    private final AgentService agentService;

    @PostMapping
    public ResponseEntity<Agent> create(@RequestBody Agent agent) {
        return ResponseEntity.ok(agentService.save(agent));
    }

    @GetMapping
    public ResponseEntity<List<Agent>> getAll() {
        return ResponseEntity.ok(agentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agent> getById(@PathVariable Long id) {
        return agentService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agent> update(@PathVariable Long id, @RequestBody Agent updated) {
        return agentService.getById(id)
                .map(existing -> {
                    existing.setName(updated.getName());
                    existing.setContactInfo(updated.getContactInfo());
                    return ResponseEntity.ok(agentService.save(existing));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        agentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
