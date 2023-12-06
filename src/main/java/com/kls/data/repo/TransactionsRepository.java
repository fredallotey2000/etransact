/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kls.data.repo;

import com.kls.data.Transactions;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bsystems4
 */
@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
   
    
    Transactions getTransaction(Long transactionsId);
    
    @Query(
            value = "SELECT * FROM transactions WHERE account_number  = ?1",
            nativeQuery = true)
    List<Transactions> getTransactions(String accountId);

}
