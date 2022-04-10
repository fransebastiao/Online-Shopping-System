package za.ac.cput.repository;

/*
 Online-Shopping-System
 Account class repository
 Author: Franciel Danilo de Carvalho Sebastiao (219466912)
 Date: 8 April 2022
*/

import za.ac.cput.entity.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository implements IRepository<Account, String>{

    private static AccountRepository repo = null;
    private List<Account> accountList = null;

    private AccountRepository(){
        accountList = new ArrayList<Account>();
    }

    public static AccountRepository getRepo(){
        if(repo == null)
            repo = new AccountRepository();
        return repo;
    }

    public List<Account> getAll() {
        return accountList;
    }

    @Override
    public Account create(Account account) {
        boolean myOperation = accountList.add(account);
        if (!myOperation)
            return null;
        return account;
    }

    @Override
    public Account read(String accountId) {
        for (Account account : accountList)
            if (account.getAccountId().equals(accountId))
                return account;
        return null;
    }

    @Override
    public Account update(Account account) {
        Account oldAccount = read(account.getAccountId());
        if (oldAccount != null){
            accountList.remove(oldAccount);
            accountList.add(account);
            return account;
        }
        return null;
    }

    @Override
    public boolean delete(String accountId) {
        Account deleteAccount = read(accountId);
        if (deleteAccount == null){
            throw new IllegalArgumentException("Failed to delete, there is nothing to delete");
        }
        accountList.remove(accountId);
        return true;
    }
}
