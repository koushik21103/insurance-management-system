package com.insurance.insurance_management.service;

import com.insurance.insurance_management.model.Customer;
import com.insurance.insurance_management.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getById(Long id) {
        return customerRepository.findById(id);
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}


