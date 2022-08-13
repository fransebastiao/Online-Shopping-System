package za.ac.cput.service.impl;
/*
Region Service test
Author: Franciel Danilo de Carvalho Sebastiao
Student Number: 219466912
Date: 13/08/2022
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Account;
import za.ac.cput.factory.AccountFactory;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class AccountServiceImplTest {
    private static final Account account1 = AccountFactory.saveAccount("01/01/2020", "01/01/2025");
    private static final Account account2 = AccountFactory.saveAccount("30/10/2015", "30/10/2035");
    private static final Account account3 = AccountFactory.saveAccount("11/03/2022", "11/03/2023");

    @Autowired
    private AccountServiceImpl service;

    @Test
    void a_save() {
        System.out.println("Saved accounts: ");
        Account saved1 = service.save(account1);
        assertNotNull(saved1);
        System.out.println(saved1);

        Account saved2 = service.save(account2);
        assertNotNull(saved2);
        System.out.println(saved2);

        Account saved3 = service.save(account3);
        assertNotNull(saved3);
        System.out.println(saved3);
    }

    @Test
    void b_read() {
        Account read = service.read(account1.getAccountId());
        assertEquals(read.getAccountId(), account1.getAccountId());
        System.out.println("Show account: " + read);
    }

    @Test
    void f_delete() {
        boolean success = service.delete(account1.getAccountId());
        assertTrue(success);
        System.out.println("Delete account: " + success);
    }

    @Test
    void d_getALl() {
        System.out.println("Show all accounts");
        System.out.println(service.findAll());
    }
}