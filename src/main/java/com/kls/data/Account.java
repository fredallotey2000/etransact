/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kls.data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Bsystems4
 */
@Entity
@Table(name = "accounts")
@NoArgsConstructor
@Getter
@Setter
public class Account implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_number")
    private long account_number;

    @Column(name = "customer_id")
    private String customer_id;

    @Column(name = "account_type")
    private String account_type;
    
    @Column(name = "currency")
    private String currency;
    
    @Column(name = "branch_id")
    private String branch_id;

    @Column(name = "account_name")
    private String account_name;

    @Column(name = "initial_balance")
    private String initial_balance;

    @Column(name = "current_balance")
    private String current_balance;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "created_by")
    private String created_by;

}

enum AccountType {
    SAVINGS,
    CHECKING,
}



