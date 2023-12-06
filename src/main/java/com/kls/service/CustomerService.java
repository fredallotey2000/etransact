/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kls.service;

import com.kls.data.Customer;
import org.springframework.stereotype.Service;

import com.kls.data.repo.CustomerRepository;

/**
 *
 * @author Bsystems4
 */
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository studentRepository) {
        this.customerRepository = studentRepository;
    }

    //Method to get a student
    public Customer getCustomer(long id) {
        Customer customer = null;
        customer = customerRepository.getCustomer(id);
        return customer;
    }
    //Method to add a new customer
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

}
