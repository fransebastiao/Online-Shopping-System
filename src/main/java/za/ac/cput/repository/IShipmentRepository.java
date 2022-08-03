package za.ac.cput.repository;

import za.ac.cput.domain.Shipment;
import java.util.Set;

public interface IShipmentRepository extends IRepository<Shipment, String>
{
    public Set<Shipment> getAll();
}
