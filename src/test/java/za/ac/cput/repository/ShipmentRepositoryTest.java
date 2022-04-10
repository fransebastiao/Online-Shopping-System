package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Shipment;
import za.ac.cput.factory.ShipmentFactory;

import static org.junit.jupiter.api.Assertions.*;

class ShipmentRepositoryTest
{
    private static ShipmentRepository repository = ShipmentRepository.getRepository();
    private static Shipment Shipment = ShipmentFactory.createShipment("2684",3265,"Tshepng","jhgs", 213698, 21436,"yyyy/dd/mm","00.00");


    @Test
    void create()
    {


        Shipment created = repository.create(Shipment);
        assertNotNull(repository.create(Shipment));
        System.out.println("Create: " + created);
    }

    @Test
    void ready()
    {
        Shipment read = repository.read(Shipment.getShipmentId());
        assertNotNull(read) ;
        System.out.println("Read: " + read);
    }

    @Test
    void update()
    {
        Shipment updated = new Shipment.Builder().copy(Shipment).setShipmentId("25584")
                .setShipmentCost(2548).setCustomerName("Molefe").setDeliveryAddress("xdfjhbfd").setContactNumber(2548).setTrackingNumber(23564).setShipmentDate("yyy/dd/mm").setShipmentTime("00.00")
                .builder();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }
    @Test

    void e_delete() {

        boolean success = repository.delete(Shipment.getShipmentId());

        assertTrue(success);

        System.out.println("Deleted: " + success);

    }

    @Test
    void getAll()
    {

        System.out.println("show all:" );
        System.out.println(repository.getAll());
    }
}