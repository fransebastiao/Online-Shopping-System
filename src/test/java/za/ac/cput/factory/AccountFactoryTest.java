package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Account;

import static org.junit.jupiter.api.Assertions.*;

class AccountFactoryTest {

    @Test
    public void test(){
        Account account = AccountFactory.openAccount("M0331", "21/03/2011", "29/10/2021");
        System.out.println(account.toString());
        assertNotNull(account);
    }

}