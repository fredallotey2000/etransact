package com.etransact.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
    AccountControllerIntegrationTest.class,
    AccountServiceIntegrationTest.class,
})

public class EtransactSuiteTest {

    public EtransactSuiteTest() {
    }

  
}
