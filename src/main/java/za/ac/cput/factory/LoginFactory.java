/*
Online Shopping System
Lihle Langa 217181147
//25.10.2022
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Login;
import za.ac.cput.util.GenericHelper;

public class LoginFactory {

    public static Login createLogin(String userEmail, String userPassword) {
        GenericHelper.checkStringParam("userEmail", userEmail);
        GenericHelper.checkStringParam("userPassword", userPassword);

        return new Login.Builder().setUserEmail(userEmail).setUserPassword(userPassword).build();
    }
}