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
import za.ac.cput.domain.UserRole;
import za.ac.cput.factory.UserRoleFactory;
import za.ac.cput.service.UserRoleService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserRoleServiceImplTest {

    UserRole userRole = UserRoleFactory.createRole("Administrator");

    @Autowired private UserRoleService roleService;

    @Order(1)
    @Test
    void save()
    {
        UserRole newRole = roleService.save(userRole);
        assertEquals(userRole, newRole);
        System.out.println("Saved Role: " + newRole);
    }

    @Order(2)
    @Test
    void read()
    {
        UserRole optionalRole = roleService.read(userRole.getRoleId());

        assertEquals(userRole.getRoleId(), optionalRole.getRoleId());

        System.out.println("Searched Role: " + optionalRole);
    }

    @Order(4)
    @Test
    void delete()
    {
        boolean isDeleted = roleService.delete(userRole.getRoleId());
        Set<UserRole> roleSet = roleService.findAll();

        assertEquals(0, roleSet.size());
        System.out.println("Deleted role: " + isDeleted);
    }

    @Order(3)
    @Test
    void findAll()
    {
        Set<UserRole> roleSet = roleService.findAll();
        System.out.println(roleSet);

        assertEquals(1, roleSet.size());
    }
}