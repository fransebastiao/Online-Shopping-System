/*
 * Shipment Test
 * Online=Shopping-System
 * 216217717
 * 12/08/2022
 * */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Shipment;
import za.ac.cput.factory.ShipmentFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ShipmentServiceImplTest {
    private static final Shipment shipment1 = ShipmentFactory.createShipment("216547", 213, "Tshepang", "13 Jon Ave", 5651, 2005,"12/08/2022", "12:00 pm");

    @Autowired
    private ShipmentServiceImpl service;

    @Test
    void a_save()
    {
        System.out.println("Shipment Details:");
        Shipment saved = this.service.save(shipment1);
        assertNotNull(saved);
        System.out.println(saved);
    }

    @Test
    void b_read()
    {
        Shipment optionalShipment = service.read(shipment1.getShipmentId());
        assertEquals(shipment1.getShipmentId(), optionalShipment.getShipmentId());
        System.out.println("Show Shipments: " + optionalShipment);
    }

    @Test
    void d_delete()
    {
        boolean isDeleted = service.delete(shipment1.getShipmentId());
        assertTrue(isDeleted);
        System.out.println("Deleted Cart: " + isDeleted);
    }

    @Test
    void c_findAll()
    {
        System.out.println("Show all shipments");
        System.out.println(service.findAll());
    }

}