/*
 Online-Shopping-System
 Factory for the Account class
 Author: Franciel Danilo de Carvalho Sebastiao (219466912)
 //25.10.2022
*/
package za.ac.cput.factory;

import za.ac.cput.domain.Region;
import za.ac.cput.util.GenericHelper;

public class RegionFactory {

    public static Region createRegion(String regionId, int streetNumber, String streetName, int zipCode){
        GenericHelper.checkStringParam("regionId", regionId);
        GenericHelper.checkStringParam("streetName", streetName);

        return new Region.Builder()
                .setRegionId(regionId)
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setZipCode(zipCode)
                .build();


    }
}