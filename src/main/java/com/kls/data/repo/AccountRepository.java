/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kls.data.repo;

import com.kls.data.Account;
import java.util.List;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bsystems4
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByFirstNameContainingIgnoreCase(String firstName);

    List<Account> getAccounts(Pageable pageable);


    Account getAccount(Long accountId);

}
