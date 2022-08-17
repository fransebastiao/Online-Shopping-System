/*
* shipment
* 216217717
* 12/08/2022
*/
package za.ac.cput.service;

import za.ac.cput.domain.Shipment;

import java.util.List;

public interface ShipmentService extends IService<Shipment, String>
{
    Set<Shipment> findAll();
    boolean deleteById(String id);
}
