package za.ac.cput.repository.Impl;
/*
UserRoleRepositoryImplTest.java
User Role Repository implementation Test
Author: Siphelele Nyathi 218334028
Date: O4.04.2022
 */
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.UserRole;
import za.ac.cput.factory.UserRoleFactory;
import za.ac.cput.repository.UserRoleRepository;
import za.ac.cput.util.GenericHelper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class UserRoleRepositoryImplTest {

    private static UserRoleRepository repository = UserRoleRepositoryImpl.getRepository();
    private static UserRole role = UserRoleFactory.createRole("Administrator");

    @Test
    @DisplayName("Should create a role ")
    void a_create(){

        assertNotNull(repository.create(role));
        System.out.println(repository.create(role));
    }

    @Test
    void c_update(){

        System.out.println("Pre-update: "+ role.toString());

        UserRole newRole = new UserRole.Builder()
                .setRoleId(GenericHelper.generateId())
                .setRoleType("Maintenance").build();

        UserRole updatedRole = repository.update(newRole);

        assertEquals("Administrator", updatedRole.getRoleType());

        System.out.println("Post-update: "+ updatedRole.toString());
        System.out.println("Get all: ");
        d_getAll();
    }

    @Test
    void b_read(){

        UserRole readRole = repository.read(role.getRoleId());

        assertEquals("Administrator", readRole.getRoleType());
        System.out.println("Read: "+ readRole.toString());
    }

    @Test
    void e_delete(){

        repository.delete(role.getRoleId());
        System.out.println(repository.getAll());
    }

    @Test
    void d_getAll(){
        assertNotNull(repository.getAll());
        System.out.println(repository.getAll());
    }
}