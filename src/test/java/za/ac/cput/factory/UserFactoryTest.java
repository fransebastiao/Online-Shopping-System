package za.ac.cput.factory;
/*
UserFactoryTest.java
Test for UserFactory class
Author: Siphelele Nyathi 218334028
Date: O4.04.2022
 */
import org.junit.jupiter.api.*;
import za.ac.cput.entity.User;
import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    private UserFactory userFactory;

    @BeforeAll
    public static void setUpAll(){
        System.out.println("Should print before all tests");
    }

    @BeforeEach
    public void setUp(){
        System.out.println("Instantiating user factory");
        userFactory = new UserFactory();
    }

    @Test
    @DisplayName("Should create contact")
    public void shouldCreateContact(){

        User user = UserFactory.createUser("Siphelele", "user@gmail.com", "12345", "Cape Town");
        System.out.println(user.toString());
        assertNotNull(user);
    }

    @Test
    @DisplayName("Should not create contact when first name is empty")
    public void shouldThrowRuntimeExcWhenFirstNameIsNull(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            User user= UserFactory.createUser("", "user@gmail.com", "12345", "Cape Town");
        });
    }

    @Test
    @DisplayName("Should not create contact when password is empty")
    public void shouldThrowRuntimeExcWhenPasswordIsNull(){

        Assertions.assertThrows(RuntimeException.class, () -> {
            User user= UserFactory.createUser("Siphelele", "user@gmail.com", "", "Cape Town");
        });
    }


    @Test
    @DisplayName("Email address should have @ symbol")
    public void shouldTestEmailFormat(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            User user = UserFactory.createUser("Siphelele", "user.co.za", "", "Cape Town");
        });
    }

    @Test
    @DisplayName("Test should be disabled")
    @Disabled
    public void shouldBeDisabled(){
        throw new RuntimeException("Test should not be executed");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("Should execute after each test");
    }

    @AfterAll
    public static void tearDownAll(){
        System.out.println("should be executed at the end of the test");
    }
}