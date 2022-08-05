package za.ac.cput.repository.Impl;
/*
        Online-Shopping-System
        Repository for OrderDetails Entity
        Author: Edvalter da Costa Jamba (220446571)
        Date: 10 April 2022
*/
import za.ac.cput.domain.OrderDetails;
import za.ac.cput.repository.IRepository;

import java.util.HashSet;
import java.util.Set;

public class OrderDetailsRepository implements IRepository<OrderDetails, String>
{

private static OrderDetailsRepository repository=null;
private Set<OrderDetails> orderDetailsDB=null;


//private Constructor
private OrderDetailsRepository()
        {
        orderDetailsDB=new HashSet<OrderDetails>();
        }
//public method
public static OrderDetailsRepository getRepository()
        {
        if(repository == null)
        {
        repository = new OrderDetailsRepository();

        }
        // in case if the data was already created
        return repository;
        }
//////////////////////////////////////////////////////////////////////////
public Set<OrderDetails> getAll()
        {
        return orderDetailsDB;
        }

@Override
public OrderDetails create(OrderDetails order)
        {
        boolean success=orderDetailsDB.add(order);
        if (!success)
        return null;
        return order;
        }

@Override
public OrderDetails read(String Ordernumber)
        {
        OrderDetails orderDetails= orderDetailsDB.stream().filter(e -> e.getOrderID() .equals(Ordernumber))
        .findAny()
        .orElse(null);
        return orderDetails;
        }

@Override
public OrderDetails update(OrderDetails orderDetails)
        {
        OrderDetails oldorder = read(orderDetails.getOrderID());
        if(oldorder!= null)
        {
        orderDetailsDB.remove(oldorder);
        orderDetailsDB.add(orderDetails);
        return orderDetails;
        }
        return null;
        }

@Override
public boolean delete(String orderID)
        {
        OrderDetails OrderToDelete= read(orderID);
        if(OrderToDelete==null)
        return false;
        orderDetailsDB.remove(OrderToDelete);
        return true;
        }

}
