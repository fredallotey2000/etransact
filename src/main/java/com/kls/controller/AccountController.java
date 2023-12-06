/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kls.controller;

import com.kls.data.Account;
import com.kls.data.Transactions;
import com.kls.data.User;
import com.kls.service.AccountService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bsystems4
 */
@RestController
@RequestMapping("etransact/api/accounts")

public class AccountController {

    private final AccountService accountService;
    
    //authenticated user to be used in user authorization for web resources
    @Autowired
    User user;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/enquiry/{accountId}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    //Method to get account balance
    public ResponseEntity getAccountBalance(@PathVariable Long accountId) {
        Account account = accountService.getAccount(accountId);
        if (account == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No account found with Id " + accountId);
        } else {
            return ResponseEntity.ok().body(account.getCurrent_balance());
        }
    }
    
    
       @RequestMapping(value = "/history/{accountId}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    //Method to get account balance
    public ResponseEntity getAccountHistory(@PathVariable String accountId) {
        List<Transactions> Transactions = accountService.getAccountHistory(accountId);
        if (Transactions == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No transactions found for Id " + accountId);
        } else {
            return ResponseEntity.ok().body(Transactions);
        }
    }

    @RequestMapping(value = "{accountId}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    //Method to retrieve account info using the customer id
    public ResponseEntity getAccount(@PathVariable Long accountId) {
        Account account = accountService.getAccount(accountId);
        if (account == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No account found with Id " + accountId);
        } else {
            return ResponseEntity.ok().body(accountId);
        }
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    //Method to create a new account
    public ResponseEntity createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).header("location", "etransact/api/accounts/" + Long.toString(createdAccount.getAccount_number())).body(Map.of("customerId", createdAccount.getAccount_name()));
    }

}
