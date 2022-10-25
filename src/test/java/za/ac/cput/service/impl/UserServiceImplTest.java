package za.ac.cput.service.impl;
/*
UserServiceImplTest.java
JUnit tests  for User Services Implementation
Siphelele Nyathi 218334028
//25.10.2022
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.service.UserService;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class UserServiceImplTest {
    private static final User user1 = UserFactory.createUser("98777", "Siphelele", "218334028@mycput.ac.za", "SN218330428", "Milnerton");
    private static final User user2 = UserFactory.createUser("93347", "Sharfaa", "257686664@mycput.ac.za", "FYH5758686", "Edgemead");
    @Autowired
    private UserServiceImpl userService;

    @Test
    void a_save()
    {
        System.out.println("Created: ");
        User created1 = userService.save(user1);
        assertNotNull(created1);
        System.out.println(created1);

        User created2 = userService.save(user2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    void b_read()
    {
        User read = userService.read(user1.getUserId());
        assertEquals(read.getUserId(), user1.getUserId());
        System.out.println("Searched User: " + read);
    }

    @Test
    void f_delete()
    {
        boolean isDeleted = userService.delete(user1.getUserId());
        assertTrue(isDeleted);
        System.out.println("Deleted User: " + isDeleted);
    }

    @Test
    void d_findAll()
    {
        Set<User> userSet = userService.findAll();
        System.out.println(userSet);
    }
}