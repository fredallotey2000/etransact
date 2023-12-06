/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kls.data.repo;

import com.kls.data.Transactions;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bsystems4
 */
@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
   
    @Query(
            value = "select \n"
            + "sch.name as sch_name,\n"
            + "c.name as class_name,\n"
            + "st.name as status_name,\n"
            + "s.* \n"
            + "from students s\n"
            + "left outer join classes c on (s.class_id = c.class_id) \n"
            + "left outer join schools sch on (s.sch_id = sch.sch_id) \n"
            + "left outer join statuses st on (s.status_id = st.status_id) WHERE s.stud_id = ?1",
            nativeQuery = true)
    Transactions getTransaction(Long transactionsId);
    
    @Query(
            value = "select \n"
            + "sch.name as sch_name,\n"
            + "c.name as class_name,\n"
            + "st.name as status_name,\n"
            + "s.* \n"
            + "from students s\n"
            + "left outer join classes c on (s.class_id = c.class_id) \n"
            + "left outer join schools sch on (s.sch_id = sch.sch_id) \n"
            + "left outer join statuses st on (s.status_id = st.status_id) WHERE s.stud_id = ?1",
            nativeQuery = true)
    List<Transactions> getTransactions(Long accountId);

}
