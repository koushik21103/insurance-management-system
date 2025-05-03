package com.insurance.insurance_management.service;

import com.insurance.insurance_management.model.Notification;
import com.insurance.insurance_management.repository.NotificationRepository;

import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }

    public Optional<Notification> getById(Long id) {
        return notificationRepository.findById(id);
    }

    public void delete(Long id) {
        notificationRepository.deleteById(id);
    }
}

