/*
 * Online-Shopping-System
 * Tshepang Molefe
 * 216217717
 * //25.10.2022
 */
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Shipment;
import za.ac.cput.factory.ShipmentFactory;
import za.ac.cput.service.ShipmentService;

import java.util.Set;

@RestController
@RequestMapping("online-shopping-system/shipment/")
@Slf4j
public class ShipmentController {
    private final ShipmentService shipmentService;

    @Autowired
    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping("save")
    public ResponseEntity<Shipment> save(@RequestBody Shipment shipment) {
        log.info("Save request: {}", shipment);
        Shipment validatedShipment;
        try {
            validatedShipment = ShipmentFactory.createShipment(shipment.getShipmentId(), shipment.getShipmentDate(), shipment.getShipmentTime(), shipment.getCustomerName(), shipment.getDeliveryAddress(), shipment.getContactNumber(), shipment.getShipmentCost(), shipment.getTrackingNumber());
        } catch (IllegalArgumentException e) {
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Shipment save = shipmentService.save(validatedShipment);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Delete request{}", id);
        this.shipmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Shipment> readId(@PathVariable String id) {
        log.info("Read request: {}", id);
        Shipment shipment = this.shipmentService.read(id);
        return ResponseEntity.ok(shipment);
    }

    @GetMapping("all")
    public ResponseEntity<Set<Shipment>> findAll() {
        Set<Shipment> shipments = this.shipmentService.findAll();
        return ResponseEntity.ok(shipments);
    }

}