package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Account;
import za.ac.cput.factory.AccountFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class AccountRepositoryTest {
    private static AccountRepository repo = AccountRepository.getRepo();
    private static Account account  = AccountFactory.saveAccount("30/09/2021","01/01/2022");

    @Test
    void a_create() {
        Account createdAccount = repo.create(account);
        assertNotNull(createdAccount);
        System.out.println("Account created:" + createdAccount);
    }

    @Test
    void b_read() {
        Account readAccount = repo.read(account.getAccountId());
        assertNotNull(readAccount);
        System.out.println("Display account:" + readAccount);
    }

    @Test
    void c_update() {
        Account updatedAccount = new Account.Builder().copy(account).setOpenDate("15/07/2015")
                .setCloseDate("15/08/2015")
                .build();
        assertNotNull(repo.update(updatedAccount));
        System.out.println("Account:" + updatedAccount + "was updated successfully");
    }

    @Test
    void d_getAll() {
        System.out.println("List of accounts");
        System.out.println(repo.getAll());
    }

    @Test
    void e_delete() {
        boolean deletedAccount = repo.delete(account.getAccountId());
        assertTrue(deletedAccount);
        System.out.println("Account was deleted:" + deletedAccount);
    }
}