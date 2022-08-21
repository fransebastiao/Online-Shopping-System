package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Login;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.LoginFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class LoginServiceImplTest {
    private static final Login login1 = LoginFactory.createLogin("first Login", " LangaLihle", " johndoe@gmail.com", " Doe1234!");
    private static final Login login2 = LoginFactory.createLogin(" second login", " Thobela", " 217181147@mycput.ac.za", " Thobela1234!");

    private LoginServiceImpl service;

    @Test
    void save() {
        System.out.println("Saved Payments: ");
        Login saved1 = service.save(login1);
        assertNotNull(saved1);
        System.out.println(saved1);

       Login saved2 = service.save(login2);
        assertNotNull(saved2);
        System.out.println(saved2);
    }

    @Test
    void read() {
        Login read = service.read(login1.getLoginid());
        assertEquals(read.getLoginid(), login1.getLoginid());
        System.out.println("Show Login: " + read);
    }

    @Test
    void delete() {
        boolean success = service.delete(login1.getLoginid());
        assertTrue(success);
        System.out.println("Delete Login: " + success);
    }

    @Test
    void findAll() {
        System.out.println("Show all Logins");
        System.out.println(service.findAll());
    }
}