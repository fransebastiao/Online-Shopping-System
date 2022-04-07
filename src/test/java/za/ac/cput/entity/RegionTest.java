package za.ac.cput.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegionTest {
    @Test
    public void regionTest(){
        Region region = new Region.Builder().setRegionId("AV200")
                .setStreetNumber(03)
                .setStreetName("Saint Louis St")
                .setZipCode(7405)
                .build();

        Region regionNo2 = new Region.Builder().setRegionId("PR100")
                .setStreetName("Voortrekker rd")
                .build();

        Region regionNo3 = new Region.Builder().setStreetName("Ilios Ave.")
                .build();

        System.out.println(region);
        System.out.println(regionNo2);
        System.out.println(regionNo3);
    }
}