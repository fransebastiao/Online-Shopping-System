package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Login;
import za.ac.cput.factory.LoginFactory;

import static org.junit.jupiter.api.Assertions.*;

class LoginRepositoryTest {

    private static LoginRepository repository = LoginRepository.getRepo();

    private static Login Login= LoginFactory.createLogin("LihleLanga"
            ,"Langa98","217181147@mycput.ac.za", "Login1234!");


    @Test
    void create() {
        Login login = repository.create(Login);
        assertEquals(Login.getLoginid(),login.getLoginid());
        System.out.println("Create: "+login);

    }

    @Test
    void read() {
        Login loginread = repository.read(Login.getLoginid());
        assertNotNull(loginread);
        System.out.println("Read: " + loginread);


    }

    @Test
    void update() {
        Login TOupdated = new Login.Builder().copy(Login).setLoginid("Yolanda Langa")
                .setUserid("Yol45")
                .setUseremail("yollanga@gmail.com")
                .setUserpassword("Langa1233!")
                .build();
        assertNotNull(repository.update(TOupdated));
        System.out.println("Updated : "+TOupdated);


    }

    @Test
    void delete() {
        boolean deleted = repository.delete(Login.getLoginid());
        assertTrue(deleted);
        System.out.println("Deleted: "+deleted);

    }
    @Test
    void getAll(){
        System.out.println("Show all");
        System.out.println(repository.getAll());

    }
}