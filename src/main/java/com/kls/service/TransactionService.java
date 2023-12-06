/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kls.service;

import com.kls.data.Transactions;
import org.springframework.stereotype.Service;

import com.kls.data.repo.TransactionsRepository;

/**
 *
 * @author Bsystems4
 */
@Service
public class TransactionService {

    private final TransactionsRepository transactionsRepository;

    public TransactionService(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    //Method to get a Transactions
    public Transactions getTransaction(long id) {
        Transactions transactions = null;
        transactions = transactionsRepository.getTransaction(id);
        return transactions;
    }
    //Method to create a new Transactions
    public Transactions createAccount(Transactions account) {
        return transactionsRepository.save(account);
    }

}
