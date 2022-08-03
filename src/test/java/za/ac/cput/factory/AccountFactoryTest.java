package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Account;

import static org.junit.jupiter.api.Assertions.*;

class AccountFactoryTest {

    @Test
    public void test(){
        Account account = AccountFactory.saveAccount("21/03/2011", "21/03/2012");
        System.out.println(account);
        assertNotNull(account);
    }
}