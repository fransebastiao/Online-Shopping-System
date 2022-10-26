/*
 * shipment
 * Online-Shopping-System
 * 216217717
 * //25.10.2022
 * */
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Shipment;
import za.ac.cput.repository.IShipmentRepository;
import za.ac.cput.service.ShipmentService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final IShipmentRepository repository;

    @Autowired
    public ShipmentServiceImpl(IShipmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Shipment save(Shipment shipment) {
        return this.repository.save(shipment);
    }

    @Override
    public Shipment read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public boolean delete(String s) {
        if (this.repository.existsById(s)) {
            this.repository.deleteById(s);
            return true;
        }
        return false;
    }


    @Override
    public Set<Shipment> findAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}