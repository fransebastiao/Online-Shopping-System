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
import za.ac.cput.domain.Shipment;
import za.ac.cput.factory.ShipmentFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ShipmentServiceImplTest

{
    //@Autowired
    //private static  Shipment shipment;
    Shipment shipment = ShipmentFactory.createShipment("216547", 213, "Tshepang", "", 5651, 2005,"12/08/2022", "12:00 pm");

    @Autowired
    private ShipmentServiceImpl shipmentServiceImpl;

    @Order(1)
    @Test
    void save()
    {
        Shipment saved = this.shipmentServiceImpl.save(this.shipment);
        assertEquals(this.shipment, saved);
        System.out.println(saved);
    }
    @Order(2)
    @Test
    void read()
    {

        Shipment optionalShipment = shipmentServiceImpl.read(shipment.getShipmentId());

        assertEquals(shipment.getShipmentId(), optionalShipment.getShipmentId());

        System.out.println("Show Shipments: " + optionalShipment);
    }
    @Order(4)
    @Test
    void delete()
    {

        boolean isDeleted = shipmentServiceImpl.delete(shipment.getShipmentId());
        Set<Shipment> shipmentSet = shipmentServiceImpl.findAll();

        assertEquals(0, shipmentSet.size());
        System.out.println("Deleted Cart: " + isDeleted);
    }
    @Order(3)
    @Test
    void findAll()
    {
        Set<Shipment> shipmentList = this.shipmentServiceImpl.findAll();
        assertEquals(1, shipmentList.size());
        System.out.println(shipmentList);
    }

}