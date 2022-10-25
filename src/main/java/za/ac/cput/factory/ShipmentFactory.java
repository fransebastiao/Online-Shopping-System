/*
 * Online-Shopping-System
 * Tshepang Molefe
 * 216217717
 * //25.10.2022
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Shipment;
import za.ac.cput.util.GenericHelper;

public class ShipmentFactory {

    public static Shipment createShipment(String shipmentId, String shipmentDate, String shipmentTime, String customerName, String deliveryAddress, String contactNumber, int shipmentCost, int trackingNumber){
        GenericHelper.checkStringParam("shipmentId", shipmentId);
        GenericHelper.checkStringParam("contactNumber", contactNumber);
        GenericHelper.checkStringParam("shipmentDate", shipmentDate);
        GenericHelper.checkStringParam("shipmentTime", shipmentTime);
        GenericHelper.checkStringParam("customerName", customerName);
        GenericHelper.checkStringParam("deliveryAddress", deliveryAddress);

        return new Shipment.Builder()
                .setShipmentId(shipmentId)
                .setContactNumber(contactNumber)
                .setShipmentCost(shipmentCost)
                .setTrackingNumber(trackingNumber)
                .setShipmentDate(shipmentDate)
                .setShipmentTime(shipmentTime)
                .setCustomerName(customerName)
                .setDeliveryAddress(deliveryAddress)
                .build();
    }
}