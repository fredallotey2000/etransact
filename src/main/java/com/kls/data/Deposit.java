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
@Table(name = "deposits")
@NoArgsConstructor
@Getter
@Setter
public class Deposit implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    
    @Column(name = "transaction_date")
    private String transaction_date;
    
    @Column(name = "amount")
    private String amount;

    @Column(name = "account_number")
    private String account_number;


    @Column(name = "transaction_status")
    private String transaction_status;

    @Column(name = "running_balance")
    private String running_balance;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "created_by")
    private String created_by;

}
