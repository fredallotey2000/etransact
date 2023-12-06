/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kls.service;

import com.kls.data.Deposit;
import org.springframework.stereotype.Service;

import com.kls.data.repo.DepositRepository;

/**
 *
 * @author Bsystems4
 */
@Service
public class DepositService {

    private final DepositRepository depositRepository;

    public DepositService(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;
    }

    //Method to get a deposit
    public Deposit getDeposit(long id) {
        Deposit deposit = null;
        deposit = depositRepository.getDeposit(id);
        return deposit;
    }
    //Method to create a new deposit
    public Deposit createDeposit(Deposit deposit) {
        return depositRepository.save(deposit);
    }

}
