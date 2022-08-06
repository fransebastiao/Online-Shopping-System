package za.ac.cput.factory;
/*
UserFactory.java
Factory class for User
Author: Siphelele Nyathi 218334028
Date: O4.04.2022
 */
import za.ac.cput.domain.User;
import za.ac.cput.util.GenericHelper;

public class UserFactory {


    public static User createUser(String name, String email, String password, String address) {


        //Simple regular expression
        if (GenericHelper.emailMatches(email, "^(.+)@(\\\\S+)$"))
            return null;

        if(GenericHelper.isNullorEmpty(name) ||
                GenericHelper.isNullorEmpty(password) ||
                GenericHelper.isNullorEmpty(address)
        )
            return null;

        return new User.Builder().setUserId(GenericHelper.generateId())
                .setName(name)
                .setEmail(email)
                .setAddress(address)
                .setPassword(password)
                .build();
    }
}
