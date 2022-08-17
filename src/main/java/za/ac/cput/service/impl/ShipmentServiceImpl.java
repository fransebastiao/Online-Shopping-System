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

import java.util.List;
import java.util.Optional;

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
    public Optional<Shipment> read(String id)
    {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Shipment shipment)
    {
        //this.repository.delete(shipment);
    }

    @Override
    public List<Shipment> findAll()
    {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id)
    {
        repository.deleteById(id);
        Optional<Shipment> Shipment = read(id);
        if (Shipment.isPresent())
        {
            delete(Shipment.get());
        }

    }
}