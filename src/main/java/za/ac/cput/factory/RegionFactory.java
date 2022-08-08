package za.ac.cput.factory;
import za.ac.cput.domain.Region;
import za.ac.cput.util.GenericHelper;
/*
 Online-Shopping-System
 Factory for the Account class
 Author: Franciel Danilo de Carvalho Sebastiao (219466912)
 Date: 7 April 2022
*/

public class RegionFactory {
    public static Region saveRegion(int streetNumber, String streetName, int zipCode){
        if(GenericHelper.isNullorEmpty(String.valueOf(streetNumber)) || GenericHelper.isNullorEmpty(streetName)
        || GenericHelper.isNullorEmpty(String.valueOf(zipCode)))
            return null;

        String regionId = GenericHelper.generateId();

        return new Region.Builder().setRegionId(regionId)
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setZipCode(zipCode)
                .build();
    }
}
