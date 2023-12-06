/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kls.controller;

import com.kls.data.Customer;
import com.kls.data.User;
import com.kls.data.Withdrawal;
import com.kls.service.CustomerService;
import com.kls.service.WithdrawalService;
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
@RequestMapping("etransact/api/withdrawals")

public class WithdrawalController {

    private final WithdrawalService withdrawalService;
    //authenticated user to be used in user authorization for web resources
    @Autowired
    User user;

    public WithdrawalController(WithdrawalService withdrawalService) {
        this.withdrawalService = withdrawalService;
    }
    
    @RequestMapping(value = "{withdrawalId}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    //Method to retrieve withdrawal info using the withdrawal id
    public ResponseEntity getWithdrawal(@PathVariable Long withdrawalId) {
        Withdrawal withdrawal = withdrawalService.getWithdrawal(withdrawalId);
        if (withdrawal == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No student found with Id " + withdrawalId);
        } else {
            return ResponseEntity.ok().body(withdrawal);
        }
    }


    @RequestMapping(
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    //Method to create a new withdrawal
    public ResponseEntity createCustomer(@RequestBody Withdrawal withdrawalModel) {
        Withdrawal withdrawal = withdrawalService.createWithdrawal(withdrawalModel);
        return ResponseEntity.status(HttpStatus.CREATED).header("location", "etransact/api/customers/" + Long.toString(withdrawal.getId())).body(Map.of("customerId", withdrawal.getId()));
    }

}
