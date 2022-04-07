package za.ac.cput.entity;

import org.junit.jupiter.api.Test;

import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    @Test
    public void accountTest(){
        Account account = new Account.Builder().setAccountId("90102")
                        .build();

        System.out.println(account);
    }
}