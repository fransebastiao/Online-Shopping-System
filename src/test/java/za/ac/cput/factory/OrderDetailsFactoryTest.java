package za.ac.cput.factory;
/*
 Online-Shopping-System
 Entity for the OrderDetailsFactoryTest
 Author: Edvalter da Costa Jamba (220446571)
 Date: 4 April 2022
 Changes Date:3 August 2022
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderDetails;
import za.ac.cput.domain.Product;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.*;


class OrderDetailsFactoryTest
{



    @Test
    public void CreateOrder()
    {
        OrderDetails orderDetails=OrderDetailsFactory.createOrderDetails(5, "R20","R100");
        System.out.println(orderDetails.toString());
        assertNotNull(orderDetails);
    }
}