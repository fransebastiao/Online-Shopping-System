package za.ac.cput.service.impl;
/*
UserServiceImplTest.java
JUnit tests  for User Services Implementation
Siphelele Nyathi 218334028
14.08.2022
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.service.UserService;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceImplTest {

    private static final User user1 = UserFactory.createUser("Siphelele Nyathi", "218334028@mycput.ac.za",
            "SN218330428", "Milnerton");

    @Autowired
    private UserService userService;

    @Test
    void a_save()
    {
        User newUser = userService.save(user1);
        assertEquals(user1, newUser);
        System.out.println("Saved User: " + newUser);
    }

    @Test
    void b_read()
    {
        User read = userService.read(user1.getUserId());
        assertEquals(read.getUserId(), user1.getUserId());
        System.out.println("Searched User: " + read);
    }

    @Test
    void d_delete()
    {
        boolean isDeleted = userService.delete(user1.getUserId());
        assertTrue(isDeleted);
        System.out.println("Deleted User: " + isDeleted);
    }

    @Test
    void c_findAll()
    {
        Set<User> userSet = userService.findAll();
        System.out.println(userSet);
    }
}