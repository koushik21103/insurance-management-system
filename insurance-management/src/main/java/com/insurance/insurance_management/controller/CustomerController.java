package com.insurance.insurance_management.controller;

import com.insurance.insurance_management.model.Customer;
import com.insurance.insurance_management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "http://localhost:3000")  // Allow React Frontend (Optional for development)
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Create Customer
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveCustomer(customer);
        return ResponseEntity.ok(savedCustomer);
    }

    // Get All Customers
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    // Get Customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update Customer
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
        return customerService.getCustomerById(id)
                .map(existingCustomer -> {
                    existingCustomer.setName(updatedCustomer.getName());
                    existingCustomer.setEmail(updatedCustomer.getEmail());
                    existingCustomer.setPhone(updatedCustomer.getPhone());
                    existingCustomer.setAddress(updatedCustomer.getAddress());
                    Customer saved = customerService.saveCustomer(existingCustomer);
                    return ResponseEntity.ok(saved);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete Customer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
