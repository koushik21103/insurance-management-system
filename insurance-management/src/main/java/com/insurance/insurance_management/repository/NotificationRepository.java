package com.insurance.insurance_management.repository;

import com.insurance.insurance_management.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
