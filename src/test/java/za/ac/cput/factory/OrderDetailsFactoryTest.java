package za.ac.cput.factory;
/*
 Online-Shopping-System
 Entity for the OrderDetailsFactoryTest
 Author: Edvalter da Costa Jamba (220446571)
 Date: 4 April 2022
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.OrderDetails;

import static org.junit.jupiter.api.Assertions.*;

class OrderDetailsFactoryTest
{
    @Test
    public void test()
    {
        OrderDetails orderDetails=OrderDetailsFactory.createOrderDetails("2"
                ,"2","Rice", Integer.parseInt("5"), "R78","R78");
        System.out.println(orderDetails.toString());
        assertNotNull(orderDetails);
    }
}