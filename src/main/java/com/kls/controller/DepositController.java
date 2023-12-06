/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kls.controller;

import com.kls.data.Deposit;
import com.kls.data.User;
import com.kls.service.DepositService;
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
@RequestMapping("etransact/api/deposits")

public class DepositController {

    private final DepositService depositService;
    //authenticated user to be used in user authorization for web resources
    @Autowired
    User user;

    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    @RequestMapping(value = "{depositId}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    //Method to retrieve customer info using the customer id
    public ResponseEntity getCustomer(@PathVariable Long depositId) {
        Deposit deposit = depositService.getDeposit(depositId);
        if (deposit == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No deposit found with Id " + depositId);
        } else {
            return ResponseEntity.ok().body(deposit);
        }
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    //Method to create a new customer
    public ResponseEntity createDeposit(@RequestBody Deposit depositModel) {
        Deposit deposit = depositService.createDeposit(depositModel);
        return ResponseEntity.status(HttpStatus.CREATED).header("location", "etransact/api/deposits/" + Long.toString(deposit.getId())).body(Map.of("customerId", deposit.getId()));
    }

}
