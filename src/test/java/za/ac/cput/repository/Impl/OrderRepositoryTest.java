package za.ac.cput.repository.Impl;
/*
        Online-Shopping-System
        Repository Test for Order Entity
        Author: Edvalter da Costa Jamba (220446571)
        Date: 10 April 2022
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.OrderFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class OrderRepositoryTest
{

    private static OrderRepository repository = OrderRepository.getRepository();
    private static Order order= OrderFactory.createOrder("2","2-Apr-2022","Delivered",
            "Edvalter", "Western Cape", Integer.parseInt("0845385688"));


    @Test
    void A_create()
    {
        Order ordercreated = repository.create(order);
        assertEquals(order.getOrderID(),ordercreated.getOrderID());
        System.out.println("Create: "+ordercreated);
    }

    @Test
    void B_read()
    {
        Order orderTOread = repository.read(order.getOrderID());
        assertNotNull(orderTOread);
        System.out.println("Read: " +orderTOread);
    }

    @Test
    void C_update()
    {
        Order TOupdated = new Order.Builder().copy(order).setCustomerName("Costa")
                .setOrderStatus("on the way")
                .build();
        assertNotNull(repository.update(TOupdated));
        System.out.println("Updated : "+TOupdated);
    }

    @Test
    void D_delete()
    {
        boolean deleted = repository.delete(order.getOrderID());
        assertTrue(deleted);
        System.out.println("Deleted: "+deleted);
    }

    @Test
    void E_getAll()
    {
        System.out.println("Show all");
        System.out.println(repository.getAll());

    }

}