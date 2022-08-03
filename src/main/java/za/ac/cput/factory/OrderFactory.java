package za.ac.cput.factory;
/*
 Online-Shopping-System
 Entity for the OrderFactory
 Author: Edvalter da Costa Jamba (220446571)
 Date: 4 April 2022
*/

import za.ac.cput.domain.Order;
import za.ac.cput.util.GenericHelper;


public class OrderFactory
{
    public static Order createOrder(String orderID, String orderDate, String orderStatus, String customerName
            , String deliveryAddress, int contactNumber)
    {

        //Validation
        if (GenericHelper.isNullorEmpty(orderID) || GenericHelper.isNullorEmpty(orderDate)||GenericHelper.isNullorEmpty(orderStatus)
                || GenericHelper.isNullorEmpty(customerName)||GenericHelper.isNullorEmpty(deliveryAddress)
                || GenericHelper.isNullorEmpty(String.valueOf(contactNumber)) )
            return null;

        //
        return new Order.Builder()
                .setOrderID(orderID)
                .setOrderDate(orderDate)
                .setOrderStatus(orderStatus)
                .setCustomerName(customerName)
                .setDeliveryAddress(deliveryAddress)
                .setContactNumber(String.valueOf(contactNumber))
                .build();

    }
}
