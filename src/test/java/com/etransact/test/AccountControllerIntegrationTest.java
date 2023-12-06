package com.etransact.test;

import com.kls.data.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class AccountControllerIntegrationTest {

    @Autowired
    TestRestTemplate testRestTemplate;
    final String accountURL = "/etransact/api/accounts";

    @Test
    //Test for user authentication
    public void testUserAuthFailure() {
        ResponseEntity<Account> response = testRestTemplate.withBasicAuth("someuser", "somepassword").
                getForEntity(accountURL + "/5", Account.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.UNAUTHORIZED);
    }

    @Test
    //Test to get an account
    public void testGetAccountSuccess() {
        ResponseEntity<Account> response = testRestTemplate.withBasicAuth("user", "user").
                getForEntity(accountURL + "/1", Account.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertNotNull(response);
//        Assertions.assertEquals(1L, response.getBody().getAccount_number());
//        Assertions.assertEquals(response.getBody().isIs_case_sensitive(), true);
    }

    @Test
    //Test to get a non existing account 
    public void testGetAccountFail() {
        ResponseEntity<String> response = testRestTemplate.withBasicAuth("user", "user").
                getForEntity(accountURL + "/-5", String.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    //Test to add a new account
    public void testAddAccount() {

        Account account = new Account();
        account.setAccount_name("Savings account");
        ResponseEntity response = testRestTemplate.withBasicAuth("user", "user").
                postForEntity(accountURL, account, null);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
//        Assertions.assertNotNull(response);
//        Assertions.assertNotNull(response.getBody().getData());
//        Assertions.assertTrue(response.getBody().isSuccess());
    }

}
