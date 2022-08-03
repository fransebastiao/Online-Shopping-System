package za.ac.cput.repository.Impl;
/*
        Online-Shopping-System
        Repository for Order Entity
        Author: Edvalter da Costa Jamba (220446571)
        Date: 10 April 2022
*/
import za.ac.cput.domain.Order;
import za.ac.cput.repository.IRepository;

import java.util.HashSet;
import java.util.Set;


public class OrderRepository implements IRepository<Order, String> {

    private static OrderRepository repository=null;
    private Set<Order> orderDB=null;

    private OrderRepository()

    {
        orderDB=new HashSet<Order>();
    }

    public static OrderRepository getRepository()
    {
        if(repository == null)
        {
            repository = new OrderRepository();

        }
        // in case if the order was already created
        return repository;
    }
    //////////////////////////////////////////////////////////////////////////
    public Set<Order> getAll()
    {
        return orderDB;
    }

    @Override
    public Order create(Order order)
    {
        boolean success=orderDB.add(order);
        if (!success)
            return null;
        return order;
    }

    @Override
    public Order read(String Ordernumber)
    {
        Order order= orderDB.stream().filter(e -> e.getOrderID() .equals(Ordernumber))
                .findAny()
                .orElse(null);
        return order;
    }

    @Override
    public Order update(Order order)
    {
        Order oldorder = read(order.getOrderID());
        if(oldorder!= null)
        {
            orderDB.remove(oldorder);
            orderDB.add(order);
            return order;
        }
        return null;
    }

    @Override
    public boolean delete(String orderID)
    {
        Order OrderToDelete= read(orderID);
        if(OrderToDelete==null)
            return false;
        orderDB.remove(OrderToDelete);
        return true;
    }

}
