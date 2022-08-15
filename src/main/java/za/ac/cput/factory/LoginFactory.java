package za.ac.cput.factory;
/*
Online Shopping System
Lihle Langa 217181147
 */
import za.ac.cput.domain.Login;
import za.ac.cput.util.GenericHelper;

public class LoginFactory {

    public static Login createLogin(String loginId, String userId, String userEmail, String userPassword){

        if(GenericHelper.isNullorEmpty(loginId) || GenericHelper.isNullorEmpty(userId))
            return null;
        return new Login.Builder().setLoginid(loginId)
                .setUserid(userId)
                .setUseremail(userEmail)
                .setUserpassword(userPassword)
                .build();


    }
}
