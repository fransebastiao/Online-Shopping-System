package za.ac.cput.factory;
/*
 Online-Shopping-System
 Entity for the OrderFactoryTest
 Author: Edvalter da Costa Jamba (220446571)
 Date: 4 April 2022
 Changes Date:3 August 2022
*/
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderDetails;
import za.ac.cput.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class OrderFactoryTest
{
    OrderDetails details = OrderDetailsFactory.createOrderDetails( 5, "R20","R100");

    @Test
    public void test()
    {

        Order order=OrderFactory.createOrder("2","22-Apr-2022","arrived"
                ,"Edvalter","Western Cape", Integer.parseInt("0845385688"), details);
        System.out.println(order.toString());
        assertNotNull(order);
    }

}