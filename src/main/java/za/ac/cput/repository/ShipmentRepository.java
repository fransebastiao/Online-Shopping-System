
/*
 * Online-Shopping-System
 * Tshepang Molefe
 * 216217717
 * 08/06/2022
 */
package za.ac.cput.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Shipment;
import java.util.Set;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, String>
{
    Set<Shipment> getAll();
}
