package za.ac.cput.factory;
/*
 Online-Shopping-System
 Entity for the OrderFactoryTest
 Author: Edvalter da Costa Jamba (220446571)
 Date: 4 April 2022
*/
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Order;

import static org.junit.jupiter.api.Assertions.*;

class OrderFactoryTest
{

    @Test
    public void test()
    {
        Order order=OrderFactory.createOrder("2","22-Apr-2022","arrived"
                ,"Edvalter","Western Cape", Integer.parseInt("0845385688"));
        System.out.println(order.toString());
        assertNotNull(order);
    }

}