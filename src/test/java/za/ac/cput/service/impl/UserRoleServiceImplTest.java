package za.ac.cput.service.impl;
/*
UserRoleServiceImplTest.java
JUnit tests  for User Role Services Implementation
Siphelele Nyathi 218334028
14.08.2022
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import za.ac.cput.domain.Account;
import za.ac.cput.domain.UserRole;
import za.ac.cput.factory.UserRoleFactory;
import za.ac.cput.service.UserRoleService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserRoleServiceImplTest {

    private static final UserRole userRole1 = UserRoleFactory.createRole("Administrator");

    @Autowired private UserRoleService roleService;

    @Test
    void a_save()
    {
        UserRole newRole = roleService.save(userRole1);
        assertEquals(userRole1, newRole);
        System.out.println("Saved Role: " + newRole);
    }

    @Test
    void b_read() {
        UserRole read = roleService.read(userRole1.getRoleId());
        assertEquals(read.getRoleId(), userRole1.getRoleId());
        System.out.println("Searched Role: " + read);
    }

    @Test
    void d_delete() {
        boolean isDeleted = roleService.delete(userRole1.getRoleId());
        assertTrue(isDeleted);
        System.out.println("Deleted role: " + isDeleted);
    }

    @Test
    void c_findAll() {
        System.out.println("User Roles");
        System.out.println(roleService.findAll());
    }
}