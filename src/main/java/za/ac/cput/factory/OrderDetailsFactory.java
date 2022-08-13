package za.ac.cput.factory;
/*
 Online-Shopping-System
 Entity for the OrderDetailsFactory
 Author: Edvalter da Costa Jamba (220446571)
 Date: 4 April 2022
 Changes Date:3 August 2022
*/

import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderDetails;
import za.ac.cput.domain.Product;
import za.ac.cput.util.GenericHelper;


public class OrderDetailsFactory
{


    public static OrderDetails createOrderDetails(int quantity, String unitCost, String subTotal, Order orderID, Product product) {
        if (GenericHelper.isNullorEmpty(String.valueOf(quantity))|| GenericHelper.isNullorEmpty(unitCost)
                || GenericHelper.isNullorEmpty(subTotal) )
            return null;

        //
        return new OrderDetails.Builder()
                .setOrderID(orderID)
                .setProductID(product)
                .setQuantity(String.valueOf(quantity))
                .setUniCost(unitCost)
                .setSubTotal(subTotal)
                .build();
    }
}
