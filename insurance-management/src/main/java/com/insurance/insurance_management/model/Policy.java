package com.insurance.insurance_management.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long policyId;

    private String name;
    private Double premiumAmount;
    private String coverageDetails;
    private String validityPeriod;

    // Linking Policy to Customer and Agent (optional if needed later)
    private Long customerId;
    private Long agentId;
}

