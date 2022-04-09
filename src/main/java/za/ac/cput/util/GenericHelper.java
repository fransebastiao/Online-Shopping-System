package za.ac.cput.util;
/*
GenericHelper.java
Helper class
Date: 08 / 04 / 2022
 */
import java.util.UUID;
import java.util.regex.Pattern;

public class GenericHelper {

    public static boolean isNullorEmpty(String s){

        return (s == null || s.isEmpty() || s.equalsIgnoreCase("null"));    }

    public static String generateId(){


        return UUID.randomUUID().toString();    }

    }

    // Simple Regular Expression for email validation
    // The absence of @ symbol fails validation
    public static boolean emailMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

}

