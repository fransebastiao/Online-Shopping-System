package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Login;

import static org.junit.jupiter.api.Assertions.*;

class LoginFactoryTest {

    @Test
    public void test(){

        Login login = LoginFactory.createLogin("Lihle.Langa", "Lihle", "217181147@mycput.ac.za", "LihleLanga20");
    }


}