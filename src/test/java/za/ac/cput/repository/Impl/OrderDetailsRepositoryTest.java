package za.ac.cput.repository.Impl;
/*
        Online-Shopping-System
        Repository Test for OrderDetails Entity
        Author: Edvalter da Costa Jamba (220446571)
        Date: 10 April 2022
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.OrderDetails;
import za.ac.cput.factory.OrderDetailsFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class OrderDetailsRepositoryTest
{

    private static OrderDetailsRepository repository = OrderDetailsRepository.getRepository();
    private static OrderDetails orderDetails= OrderDetailsFactory.createOrderDetails("1"
            ,"2","Rice",
            Integer.parseInt("5"), "R78","R78");


    @Test
    void A_create()
    {
        OrderDetails orderDet = repository.create(orderDetails);
        assertEquals(orderDetails.getOrderID(),orderDet.getOrderID());
        System.out.println("Create: "+orderDet);
    }

    @Test
    void B_read()
    {
        OrderDetails orderTOread = repository.read(orderDetails.getOrderID());
        assertNotNull(orderTOread);
        System.out.println("Read: " +orderTOread);
    }

    @Test
    void C_update()
    {
        OrderDetails TOupdated = new OrderDetails.Builder().copy(orderDetails).setProductName("Potato")
                .setQuantity("5")
                .build();
        assertNotNull(repository.update(TOupdated));
        System.out.println("Updated : "+TOupdated);
    }

    @Test
    void D_delete()
    {
        boolean deleted = repository.delete(orderDetails.getOrderID());
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