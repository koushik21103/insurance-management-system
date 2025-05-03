package com.insurance.insurance_management.controller;

import com.insurance.insurance_management.model.Notification;
import com.insurance.insurance_management.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Notification> create(@RequestBody Notification notification) {
        return ResponseEntity.ok(notificationService.save(notification));
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getAll() {
        return ResponseEntity.ok(notificationService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getById(@PathVariable Long id) {
        return notificationService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notification> update(@PathVariable Long id, @RequestBody Notification updated) {
        return notificationService.getById(id)
                .map(existing -> {
                    existing.setMessage(updated.getMessage());
                    existing.setNotificationType(updated.getNotificationType());
                    existing.setIsRead(updated.getIsRead());
                    existing.setCustomer(updated.getCustomer());
                    return ResponseEntity.ok(notificationService.save(existing));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        notificationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
