package com.insurance.insurance_management.repository;

import com.insurance.insurance_management.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    // Custom notification queries if needed later
}
