
/*
 * Online-Shopping-System
 * Tshepang Molefe
 * 216217717
 * 10/04/2022
 */
package za.ac.cput.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Shipment;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ShipmentFactoryTest
{


    @Test

    void createShipment()
    {
        Shipment shipment = ShipmentFactory.createShipment("2136984",  2365,  "Tshepang",
                "p.o.box 27",  7914793,  23698542,
                "yyyy/mm/dd",  "00.00");
        System.out.print(shipment);
        assertNotNull(shipment);
    }



}