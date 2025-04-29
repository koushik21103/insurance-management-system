package com.insurance.insurance_management.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claimId;

    private Long policyId;
    private Long customerId;
    private Double claimAmount;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        FILED, UNDER_REVIEW, APPROVED, REJECTED
    }
}

