package za.ac.cput.service.impl;
/*
Account Service test
Author: Franciel Danilo de Carvalho Sebastiao
Student Number: 219466912
Date: 13/08/2022
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Region;
import za.ac.cput.factory.RegionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class RegionServiceImplTest {
    private static final Region region1 = RegionFactory.saveRegion(432, "Voortrekker rd",7500);
    private static final Region region2 = RegionFactory.saveRegion(10, "Strand st", 8000);
    private static final Region region3 = RegionFactory.saveRegion(91, "Willow way", 7405);

    @Autowired
    private RegionServiceImpl service;

    @Test
    void a_save() {
        System.out.println("Saved Regions: ");
        Region saved1 = service.save(region1);
        assertNotNull(saved1);
        System.out.println(saved1);

        Region saved2 = service.save(region2);
        assertNotNull(saved2);
        System.out.println(saved2);

        Region saved3 = service.save(region3);
        assertNotNull(saved3);
        System.out.println(saved3);
    }

    @Test
    void b_read() {
        Region read = service.read(region1.getRegionId());
        assertEquals(read.getRegionId(), region1.getRegionId());
        System.out.println("Show region: " + read);
    }

    @Test
    void f_delete() {
        boolean success = service.delete(region1.getRegionId());
        assertTrue(success);
        System.out.println("Delete region: " + success);
    }

    @Test
    void d_getALl() {
        System.out.println("Show all regions");
        System.out.println(service.findAll());
    }
}