package za.ac.cput.factory;
/*
 Online-Shopping-System
 Entity for the OrderDetailsFactory
 Author: Edvalter da Costa Jamba (220446571)
 Date: 4 April 2022
*/

import za.ac.cput.entity.OrderDetails;
import za.ac.cput.util.GenericHelper;


public class OrderDetailsFactory
{
    public static OrderDetails createOrderDetails(String orderID, String productID, String productName
            , int quantity  , String unitCost, String subTotal)
    {

        //Validation
        if (GenericHelper.isNullorEmpty(orderID) || GenericHelper.isNullorEmpty(productID)|| GenericHelper.isNullorEmpty(productName)
                || GenericHelper.isNullorEmpty(String.valueOf(quantity))|| GenericHelper.isNullorEmpty(unitCost)
                || GenericHelper.isNullorEmpty(subTotal) )
            return null;

        //
        return new OrderDetails.Builder()
                .setOrderID(orderID)
                .setProductID(productID)
                .setProductName(productName)
                .setQuantity(String.valueOf(quantity))
                .setUniCost(unitCost)
                .setSubTotal(subTotal)
                .build();

    }
}
