package za.ac.cput.util;

import java.util.UUID;

public class GenericHelper {


<<<<<<< HEAD

    public static boolean isNullorEmpty(String s){

        return (s == null || s.isEmpty() || s.equalsIgnoreCase("null"));    }

    public static String generateId(){

        return UUID.randomUUID().toString();    }

=======
    public static boolean isNullorEmpty(String s){

        return (s == null || s.isEmpty() || s.equalsIgnoreCase("null"));
    }

    public static String generateId(){

        return UUID.randomUUID().toString();
    }
>>>>>>> origin/217181147
}
