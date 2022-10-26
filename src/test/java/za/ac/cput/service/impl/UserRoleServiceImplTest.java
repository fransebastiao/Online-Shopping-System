package za.ac.cput.service.impl;
/*
UserRoleServiceImplTest.java
JUnit tests  for User Role Services Implementation
Siphelele Nyathi 218334028
//25.10.2022
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.UserRole;
import za.ac.cput.factory.UserRoleFactory;
import za.ac.cput.service.UserRoleService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class UserRoleServiceImplTest {

    private static final UserRole userRole1 = UserRoleFactory.createUserRole("67588","Administrator");
    private static final UserRole userRole2 = UserRoleFactory.createUserRole("67455","Administrator");
    @Autowired
    private UserRoleServiceImpl roleService;

    @Test
    void a_save()
    {
        System.out.println("Created: ");
        UserRole created1 = roleService.save(userRole1);
        assertNotNull(created1);
        System.out.println(created1);

        UserRole created2 = roleService.save(userRole2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    void b_read() {
        UserRole read = roleService.read(userRole1.getRoleId());
        assertEquals(read.getRoleId(), userRole1.getRoleId());
        System.out.println("Searched Role: " + read);
    }

    @Test
    void f_delete() {
        boolean isDeleted = roleService.delete(userRole1.getRoleId());
        assertTrue(isDeleted);
        System.out.println("Deleted role: " + isDeleted);
    }

    @Test
    void d_findAll() {
        System.out.println("User Roles");
        System.out.println(roleService.findAll());
    }
}