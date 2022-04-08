package za.ac.cput.repository;

import java.util.UUID;

public class UserRepository {

    public static boolean isNullorEmpty(String s){

        return (s == null || s.isEmpty() || s.equalsIgnoreCase("null"));
    }

    public static String generateId(){

        return UUID.randomUUID().toString();
    }

    /*public static String generateId(){
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 8;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;*/
}
