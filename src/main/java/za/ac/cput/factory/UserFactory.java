/*
UserFactory.java
Factory class for User
Author: Siphelele Nyathi 218334028
//25.10.2022
 */
package za.ac.cput.factory;

import za.ac.cput.domain.User;
import za.ac.cput.util.GenericHelper;

public class UserFactory {

    public static User createUser(String userId,String name, String email, String password, String address){
        GenericHelper.checkStringParam("userId", userId);
        GenericHelper.checkStringParam("email", email);
        GenericHelper.checkStringParam("name", name);
        GenericHelper.checkStringParam("password", password);
        GenericHelper.checkStringParam("address", address);

        return new User.Builder()
                .setUserId(userId)
                .setEmail(email)
                .setName(name)
                .setPassword(password)
                .setAddress(address)
                .build();


    }
}