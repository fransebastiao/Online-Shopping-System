package za.ac.cput.factory;

import za.ac.cput.entity.Login;
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
