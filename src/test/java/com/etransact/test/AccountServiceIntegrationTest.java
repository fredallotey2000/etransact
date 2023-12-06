package com.etransact.test;

import com.kls.data.Account;
import com.kls.service.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AccountServiceIntegrationTest {

    @Autowired
    AccountService AccountService;

    @Test
    public void testGetAccountSuccess() {
        Account account = null;
        account = AccountService.getAccount(1L);
        Assertions.assertNotNull(account);
        //Assertions.assertEquals(true, Account.isIs_case_sensitive());
    }

    @Test
    public void testGetAccountFail() {
        Account Account = null;
        Account = AccountService.getAccount(100L);
        Assertions.assertNull(Account);
    }


    @Test
    public void testAddAccountSuccess() {
        Account Account = new Account();
        Account.setAccount_name("Frederick Allotey");
        Account created = AccountService.createAccount(Account);
        Assertions.assertNotNull(created);
       // Assertions.assertTrue(Arrays.asList(Account.getEntries()).containsAll(Arrays.asList(new String[]{"bo", "o"})));
    }

}
