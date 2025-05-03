package com.insurance.insurance_management.repository;

import com.insurance.insurance_management.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
