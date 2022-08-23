

/*
 * Online-Shopping-System
 * Tshepang Molefe
 * 216217717
 * 10/04/2022
 */

package za.ac.cput.factory;

import za.ac.cput.domain.Shipment;
import za.ac.cput.util.GenericHelper;


public class ShipmentFactory
{
    // create all shipment object
    public static Shipment createShipment(String shipmentId, int shipmentCost, String customerName, String deliveryAddress,
                                          int contactNumber, int trackingNumber, String shipmentDate, String shipmentTime) {


        if (GenericHelper.isNullorEmpty(shipmentId))
            return null;


        return new Shipment.Builder().setShipmentId(shipmentId).
                setShipmentCost(shipmentCost).
                setCustomerName(customerName).
                setDeliveryAddress(deliveryAddress).
                setContactNumber(contactNumber).
                setTrackingNumber(trackingNumber).
                setShipmentDate(shipmentDate).
                setShipmentTime(shipmentTime)
                .build();
    }

    public static Shipment build(String shipmentId, int shipmentCost,
                                 String customerName, String deliveryAddress, int contactNumber, int trackingNumber,
                                 String shipmentDate, String shipmentTime) {
        return new Shipment.Builder().setShipmentId(shipmentId).
                setShipmentCost(shipmentCost).
                setCustomerName(customerName).
                setDeliveryAddress(deliveryAddress).
                setContactNumber(contactNumber).
                setTrackingNumber(trackingNumber).
                setShipmentDate(shipmentDate).
                setShipmentTime(shipmentTime)
                .build();
    }
}