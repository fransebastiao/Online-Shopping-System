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

    User user = UserFactory.createUser("Siphelele Nyathi", "218334028@mycput.ac.za",
            "SN218330428", "Milnerton");

    @Autowired
    private UserService userService;

    @Order(1)
    @Test
    void save()
    {
        User newUser = userService.save(user);

        assertEquals(user, newUser);
        System.out.println("Saved User: " + newUser);
    }

    @Order(2)
    @Test
    void read()
    {
        User optionalUser = userService.read(user.getUserId());

        assertEquals(user.getUserId(), optionalUser.getUserId());

        System.out.println("Searched User: " + optionalUser);
    }

    @Order(4)
    @Test
    void delete()
    {
        boolean isDeleted = userService.delete(user.getUserId());
        Set<User> userSet = userService.findAll();

        assertEquals(0, userSet.size());
        System.out.println("Deleted User: " + isDeleted);
    }

    @Order(3)
    @Test
    void findAll()
    {
        Set<User> userSet = userService.findAll();
        assertEquals(1, userSet.size());

        System.out.println(userSet);
    }
}