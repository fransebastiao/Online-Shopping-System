/*
 Online-Shopping-System
 Entity for the OrderFactory
 Author: Edvalter da Costa Jamba (220446571)
 //25.10.2022
*/
package za.ac.cput.factory;

import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderDetails;
import za.ac.cput.util.GenericHelper;

public class OrderFactory {

    public static Order createOrder(String orderId, String orderDate, String orderStatus, String customerName, String deliveryAddress, int contactNumber, OrderDetails details){
        GenericHelper.checkStringParam("orderId", orderId);
        GenericHelper.checkStringParam("orderDate", orderDate);
        GenericHelper.checkStringParam("orderStatus", orderStatus);
        GenericHelper.checkStringParam("customerName", customerName);
        GenericHelper.checkStringParam("deliveryAddress", deliveryAddress);


        return new Order.Builder()
                .setOrderId(orderId)
                .setOrderDate(orderDate)
                .setOrderStatus(orderStatus)
                .setCustomerName(customerName)
                .setDeliveryAddress(deliveryAddress)
                .setContactNumber(contactNumber)
                .setDetails(details)
                .build();


    }
}