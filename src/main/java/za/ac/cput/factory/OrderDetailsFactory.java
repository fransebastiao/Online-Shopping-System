/*
 Online-Shopping-System
 Entity for the OrderDetailsFactory
 Author: Edvalter da Costa Jamba (220446571)
 //25.10.2022
*/
package za.ac.cput.factory;

import za.ac.cput.domain.OrderDetails;
import za.ac.cput.util.GenericHelper;

public class OrderDetailsFactory {

    public static OrderDetails createOrderDetails(int quantity, String unitCost, String subTotal){
        GenericHelper.checkStringParam("unitCost", unitCost);
        GenericHelper.checkStringParam("subTotal", subTotal);

        return new OrderDetails.Builder()
                .setQuantity(quantity)
                .setUnitCost(unitCost)
                .setSubTotal(subTotal)
                .build();


    }
}