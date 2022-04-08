package za.ac.cput.factory;
import za.ac.cput.entity.Account;
import za.ac.cput.entity.Region;
/*
 Online-Shopping-System
 Factory for the Account class
 Author: Franciel Danilo de Carvalho Sebastiao (219466912)
 Date: 7 April 2022
*/

public abstract class AccountFactory {

    public static Account openAccount(String accountId, String openDate, String closeDate){

        return new Account.Builder().setAccountId(accountId)
                .setOpenDate(openDate)
                .setCloseDate(closeDate)
                .build();
    }
}
