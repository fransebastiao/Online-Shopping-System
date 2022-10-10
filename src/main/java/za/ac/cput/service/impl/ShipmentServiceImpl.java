/*
 * shipment
 * Online-Shopping-System
 * 216217717
 *  12/08/2022
 * */
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Shipment;
import za.ac.cput.repository.ShipmentRepository;
import za.ac.cput.service.ShipmentService;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShipmentServiceImpl implements ShipmentService
{
    private final ShipmentRepository repository;

    @Autowired
    public ShipmentServiceImpl(ShipmentRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public Shipment save(Shipment shipment)
    {
        return this.repository.save(shipment);
    }

    @Override
    public Shipment read(String id)
    {
        return this.repository.findById(id).orElse(null);
    }



    @Override
    public Set<Shipment> findAll()
    {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public boolean delete(String id)
    {
        if (this.repository.existsById(id))
        {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }
}