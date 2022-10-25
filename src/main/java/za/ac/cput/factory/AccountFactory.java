/*
 Online-Shopping-System
 Factory for the Account class
 Author: Franciel Danilo de Carvalho Sebastiao (219466912)
 //25.10.2022
*/
package za.ac.cput.factory;

import za.ac.cput.domain.Account;

import za.ac.cput.util.GenericHelper;

public class AccountFactory {

    public static Account createAccount(String accountId, String openDate, String closeDate){
        GenericHelper.checkStringParam("accountId", accountId);
        GenericHelper.checkStringParam("openDate", openDate);
        GenericHelper.checkStringParam("closeDate", closeDate);

        return new Account.Builder().setAccountId(accountId)
                .setOpenDate(openDate)
                .setCloseDate(closeDate)
                .build();


    }

}