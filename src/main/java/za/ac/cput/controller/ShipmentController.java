package za.ac.cput.controller;
/*
 * Online-Shopping-System
 * Tshepang Molefe
 * 216217717
 * 10/04/2022
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Shipment;
import za.ac.cput.service.ShipmentService;

import java.util.Set;

@RestController
@RequestMapping("school-management/student-address/")
@Slf4j
public class ShipmentController
{
    private final ShipmentService shipmentService;

    @Autowired
    public ShipmentController(ShipmentService shipmentService)
    {
        this.shipmentService = shipmentService;
    }
    @PostMapping("save")
    public ResponseEntity<Shipment> save(@RequestBody Shipment shipment)
    {
        Shipment save = this.shipmentService.save(shipment);
        return ResponseEntity.ok(save);
        }



    @DeleteMapping("delete/{id}")
    public ResponseEntity <Shipment> delete (@PathVariable String id  )
    {
        log.info("Read request: {}", id);
        this.shipmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}/{quality}, {dateAdded}")

    public ResponseEntity<Shipment> read (@PathVariable String id)
        {
        log.info("Read request: {}", id);
        Shipment shipment = this.shipmentService.read(id);
        return ResponseEntity.ok(shipment);
    }

    @GetMapping("all")
    public ResponseEntity<Set<Shipment>> findAll()
    {
        Set<Shipment> Shipment = this.shipmentService.findAll();
        return ResponseEntity.ok(Shipment);
    }
}
