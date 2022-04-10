package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Region;
import za.ac.cput.factory.RegionFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class RegionRepositoryTest {
    private static RegionRepository repo = RegionRepository.getRepo();
    private static Region region  = RegionFactory.saveRegion(14,"Bronks", 8000);

    @Test
    void a_create() {
        Region createdRegion = repo.create(region);
        assertNotNull(createdRegion);
        System.out.println("Region created:" + createdRegion);
    }

    @Test
    void b_read() {
        Region readRegion = repo.read(region.getRegionId());
        assertNotNull(readRegion);
        System.out.println("Display region:" + readRegion);
    }

    @Test
    void c_update() {
        Region updatedRegion = new Region.Builder().copy(region).setStreetNumber(27)
                .setStreetName("D-Block")
                .setZipCode(3900)
                .build();
        assertNotNull(repo.update(updatedRegion));
        System.out.println("Region:" + updatedRegion + "was updated successfully");
    }

    @Test
    void d_getAll() {
        System.out.println("List of Regions");
        System.out.println(repo.getAll());
    }

    @Test
    void e_delete() {
        boolean deletedRegion = repo.delete(region.getRegionId());
        assertTrue(deletedRegion);
        System.out.println("Region was deleted:" + deletedRegion);
    }
}