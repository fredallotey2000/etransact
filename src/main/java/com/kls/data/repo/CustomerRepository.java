/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kls.data.repo;


import java.util.List;
import org.springframework.data.domain.Pageable;
import com.kls.data.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bsystems4
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByFirstNameContainingIgnoreCase(String firstName);


    List<Customer> getAllCustomers(Pageable pageable);

    Customer getCustomer(Long customerId);

}
