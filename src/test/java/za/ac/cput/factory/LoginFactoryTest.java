package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Login;

import static org.junit.jupiter.api.Assertions.*;

class LoginFactoryTest {

    @Test
    public void test(){

        Login login = LoginFactory.createLogin("217181147@mycput.ac.za", "LihleLanga20");

        assertNotNull(login);
        System.out.println(login);

    }



}