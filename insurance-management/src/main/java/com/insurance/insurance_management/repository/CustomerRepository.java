package com.insurance.insurance_management.repository;

import com.insurance.insurance_management.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // You can add custom queries here if needed later
}
