//25.10.2022
package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Login;
import za.ac.cput.factory.LoginFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class LoginServiceImplTest {
    private static final Login login1 = LoginFactory.createLogin(" johndoe@gmail.com", " Doe1234!");
    private static final Login login2 = LoginFactory.createLogin(" 217181147@mycput.ac.za", " Thobela1234!");

    @Autowired
    private LoginServiceImpl service;

    @Test
    void a_save() {
        System.out.println("Created: ");
        Login saved1 = service.save(login1);
        assertNotNull(saved1);
        System.out.println(saved1);

        Login saved2 = service.save(login2);
        assertNotNull(saved2);
        System.out.println(saved2);
    }

    @Test
    void b_read() {
        Login read = service.read(login1.getUserEmail());
        assertEquals(read.getUserEmail(), login1.getUserEmail());
        System.out.println("Show Login: " + read);
    }

    @Test
    void f_delete() {
        boolean success = service.delete(login1.getUserEmail());
        assertTrue(success);
        System.out.println("Delete Login: " + success);
    }

    @Test
    void d_findAll() {
        System.out.println("Show all Logins");
        System.out.println(service.findAll());
    }
}