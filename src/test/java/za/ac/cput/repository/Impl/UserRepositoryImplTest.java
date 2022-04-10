package za.ac.cput.repository.Impl;
/*
UserRepositoryImplTest.java
User Repository Test
Author: Siphelele Nyathi 218334028
Date: O4.04.2022
 */
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.repository.UserRepository;
import za.ac.cput.util.GenericHelper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



class UserRepositoryImplTest {

    private static UserRepository repository = UserRepositoryImpl.getRepository();
    private static User user = UserFactory.createUser("Siphelele", "user@domain.com", "12345", "Cape Town");

    @Test
    void a_create(){
        assertNotNull(repository.create(user));
        System.out.println(repository.create(user));
    }

    @Test
    void c_update(){

        System.out.println("Pre-update: " + user.toString());

        User newUser = new User.Builder().setUserId(GenericHelper.generateId())
                .setName("Sheriff")
                .setEmail("abc@gmail.com")
                .setPassword("0000")
                .setAddress("California").build();

        User updatedUser = repository.update(newUser);

        assertEquals("Siphelele", updatedUser.getName());

        System.out.println("Post-uodate: "+ updatedUser.toString());
        System.out.println("Get All: ");
        d_getAll();
    }

    @Test
    void b_read(){

        User readUser = repository.read(user.getUserId());

        assertEquals("Siphelele", readUser.getName());
        System.out.println("Read: " + readUser.toString());
    }

    @Test
    void e_delete(){

        repository.delete(user.getUserId());
        System.out.println(repository.getAll());
    }

    @Test
    void d_getAll(){

        assertNotNull(repository.getAll());
        System.out.println(repository.getAll());
    }
}