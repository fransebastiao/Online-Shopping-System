/*
* Shipment Test
* 216217717
* 12/08/2022
* */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Shipment;
import za.ac.cput.factory.ShipmentFactory;
import za.ac.cput.service.ShipmentService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ShipmentServiceImplTest

{
    @Autowired
    private  Shipment shipment;

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
        Optional<Shipment> read = this.shipmentServiceImpl.read(this.shipment.getShipmentId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.shipment, read.get()));
    }
    @Order(4)
    @Test
    void delete()
    {
        this.shipmentServiceImpl.deleteById(this.shipment.getShipmentId());
        List<Shipment> shipmentList = this.shipmentServiceImpl.findAll();
        assertEquals(0, shipmentList.size());
    }
    @Order(3)
    @Test
    void findAll()
    {
        List<Shipment> shipmentList = this.shipmentServiceImpl.findAll();
        assertEquals(1, shipmentList.size());
        System.out.println(shipmentList);
    }

}