/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kls.data.repo;

import com.kls.data.Withdrawal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bsystems4
 */
@Repository
public interface WithdrawalRepository extends JpaRepository<Withdrawal, Long> {
   
    Withdrawal getWithdrawal(Long withdrawalId);

}
