/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kls.service;

import com.kls.data.Account;
import com.kls.data.Transactions;
import com.kls.data.repo.AccountRepository;
import com.kls.data.repo.TransactionsRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bsystems4
 */
@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final TransactionsRepository transactionsRepository;

    public AccountService(AccountRepository accountRepository, TransactionsRepository transactionsRepository) {
        this.accountRepository = accountRepository;
        this.transactionsRepository = transactionsRepository;

    }

    //Method to get an account
    public Account getAccount(long id) {
        Account account = null;
        account = accountRepository.getAccount(id);
        return account;
    }

    //Method to get a history
    public  List<Transactions> getAccountHistory(String accountNumber) {
         List<Transactions> transactions = null;
        transactions = transactionsRepository.getTransactions(accountNumber);
        return transactions;
    }

    //Method to get an account
    public Account getAccountBalance(long id) {
        Account account = null;
        account = accountRepository.getAccount(id);
        return account;
    }

    //Method to create a new account
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

}
