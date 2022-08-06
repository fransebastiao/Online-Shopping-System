package za.ac.cput.factory;
/*
 Online-Shopping-System
 Entity for the OrderDetailsFactoryTest
 Author: Edvalter da Costa Jamba (220446571)
 Date: 4 April 2022
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderDetails;
import za.ac.cput.domain.Product;

import static org.junit.jupiter.api.Assertions.*;


class OrderDetailsFactoryTest
{
    Order order = OrderFactory.createOrder("1","12/08/2022","on the way",
            "Edvalter","Cape town", Integer.parseInt("877888333"));

    Product product = ProductFactory.createProduct("Rice","EC","R123");

    @Test
    public void test()
    {
        OrderDetails orderDetails=OrderDetailsFactory.createOrderDetails(order,product, Integer.parseInt("5"), "R78","R78");
        System.out.println(orderDetails.toString());
        assertNotNull(orderDetails);
    }
}