package za.ac.cput.factory;
import za.ac.cput.domain.Account;
import za.ac.cput.util.GenericHelper;
/*
 Online-Shopping-System
 Factory for the Account class
 Author: Franciel Danilo de Carvalho Sebastiao (219466912)
 Date: 7 April 2022
*/

public class AccountFactory {

    public static Account saveAccount(String openDate, String closeDate){
        if(GenericHelper.isNullorEmpty(openDate) || GenericHelper.isNullorEmpty(closeDate))
            return null;

        String accountId = GenericHelper.generateId();

        return new Account.Builder().setAccountId(accountId)
                .setOpenDate(openDate)
                .setCloseDate(closeDate)
                .build();
    }
}