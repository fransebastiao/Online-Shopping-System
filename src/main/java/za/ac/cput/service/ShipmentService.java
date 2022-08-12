package za.ac.cput.service;

import za.ac.cput.domain.Shipment;

import java.util.List;

public interface ShipmentService extends IService<Shipment, String>
{
    List<Shipment> findAll();
    void deleteById(String id);
}
