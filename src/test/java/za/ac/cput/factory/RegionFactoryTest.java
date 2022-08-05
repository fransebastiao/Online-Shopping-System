package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Region;

import static org.junit.jupiter.api.Assertions.*;

class RegionFactoryTest {

    @Test
    public void test(){
        Region region = RegionFactory.saveRegion(2, "Ilios Avenue", 7540);
        System.out.println(region);
        assertNotNull(region);
    }

}