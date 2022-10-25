/*
 * Shipment Test
 * Online=Shopping-System
 * 216217717 //25.10.2022
 * */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Shipment;
import za.ac.cput.factory.ShipmentFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class ShipmentServiceImplTest {
    private static final Shipment shipment1 = ShipmentFactory.createShipment("216547", "09/02/2022", "19:00", "John Able", "16 Finn Road", "0744330576", 789, 12556);
    private static final Shipment shipment2 = ShipmentFactory.createShipment("635289", "24/03/2022", "13:02", "Tshepang", "81 Maple Street", "0614406789",2000, 61551);

    @Autowired
    private ShipmentServiceImpl service;

    @Test
    void a_save()
    {
        System.out.println("Shipment Details created:");
        Shipment saved1 = this.service.save(shipment1);
        assertNotNull(saved1);
        System.out.println(saved1);

        Shipment saved2 = this.service.save(shipment2);
        assertNotNull(saved2);
        System.out.println(saved2);
    }

    @Test
    void b_read()
    {
        Shipment optionalShipment = service.read(shipment1.getShipmentId());
        assertEquals(shipment1.getShipmentId(), optionalShipment.getShipmentId());
        System.out.println("Show Shipments: " + optionalShipment);
    }

    @Test
    void f_delete()
    {
        boolean success = service.delete(shipment2.getShipmentId());
        assertTrue(success);
        System.out.println("Deleted Cart: " + success);
    }

    @Test
    void d_findAll()
    {
        System.out.println("Show all shipments");
        System.out.println(service.findAll());
    }

}