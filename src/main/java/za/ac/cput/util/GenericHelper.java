package za.ac.cput.util;

import java.util.UUID;

public class GenericHelper {


    public static boolean isNullorEmpty(String s){

        return (s == null || s.isEmpty() || s.equalsIgnoreCase("null"));
    }

    public static String generateId(){

        return UUID.randomUUID().toString();
    }
}
