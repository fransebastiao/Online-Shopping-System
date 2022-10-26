package za.ac.cput.service.impl;
/*
Region Service test
Author: Franciel Danilo de Carvalho Sebastiao
Student Number: 219466912
//25.10.2022
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
public class AccountServiceImplTest {
    private static final Account account1 = AccountFactory.createAccount("12345678","01/01/2020", "01/01/2025");
    private static final Account account2 = AccountFactory.createAccount("87654321","30/10/2015", "30/10/2035");
    private static final Account account3 = AccountFactory.createAccount("00334466","11/03/2022", "11/03/2023");

    @Autowired
    private AccountServiceImpl service;

    @Test
    void a_save() {
        System.out.println("Created: ");
        Account created1 = service.save(account1);
        assertNotNull(created1);
        System.out.println(created1);

        Account created2 = service.save(account2);
        assertNotNull(created2);
        System.out.println(created2);

        Account created3 = service.save(account3);
        assertNotNull(created3);
        System.out.println(created3);
    }

    @Test
    void b_read() {
        Account read = service.read(account1.getAccountId());
        assertEquals(read.getAccountId(), account1.getAccountId());
        System.out.println("Show account: " + read);
    }

    @Test
    void f_delete() {
        boolean success = service.delete(account3.getAccountId());
        assertTrue(success);
        System.out.println("Delete account: " + success);
    }

    @Test
    void d_getALl() {
        System.out.println("Show all accounts: ");
        System.out.println(service.findAll());
    }
}