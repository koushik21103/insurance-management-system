package com.insurance.insurance_management.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;

    private Long customerId;
    private String message;
    private String notificationType;  // E.g., POLICY_RENEWAL, CLAIM_STATUS, etc.

    private Boolean isRead = false;
}

