package za.ac.cput.service.impl;
/*
        Online-Shopping-System
        Services:OrderServiceImpl
        Author: Edvalter da Costa Jamba (220446571)
        Date: 10 August 2022

*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Order;
import za.ac.cput.repository.OrderRepository;
import za.ac.cput.service.OrderService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService
{

    private final OrderRepository repository;

    @Autowired
    public OrderServiceImpl(OrderRepository repository)
    {
        this.repository = repository;
    }


    @Override
    public Order save(Order order) {
        return this.repository.save(order);
    }

    @Override
    public Order read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Set<Order> findAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public boolean delete(String id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }
}
