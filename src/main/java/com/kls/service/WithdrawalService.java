/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kls.service;

import com.kls.data.Account;
import com.kls.data.Withdrawal;
import com.kls.data.repo.AccountRepository;
import com.kls.data.repo.WithdrawalRepository;
import org.springframework.stereotype.Service;


/**
 *
 * @author Bsystems4
 */
@Service
public class WithdrawalService {

    private final WithdrawalRepository withdrawalRepository;

    public WithdrawalService(WithdrawalRepository withdrawalRepository) {
        this.withdrawalRepository = withdrawalRepository;
    }

    //Method to get a Withdrawal
    public Withdrawal getWithdrawal(long id) {
        Withdrawal withdrawal = null;
        withdrawal = withdrawalRepository.getWithdrawal(id);
        return withdrawal;
    }
    //Method to create a new Withdrawal
    public Withdrawal createWithdrawal(Withdrawal withdrawal) {
        return withdrawalRepository.save(withdrawal);
    }

}
