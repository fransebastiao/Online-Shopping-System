/*
        Online-Shopping-System
        Services:OrderServiceImpl
        Author: Edvalter da Costa Jamba (220446571)
        //25.10.2022
*/
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Order;
import za.ac.cput.repository.IOrderRepository;
import za.ac.cput.service.OrderService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final IOrderRepository repository;

    @Autowired
    public OrderServiceImpl(IOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order save(Order order) {
        return this.repository.save(order);
    }

    @Override
    public Order read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public boolean delete(String s) {
        if (this.repository.existsById(s)) {
            this.repository.deleteById(s);
            return true;
        }
        return false;
    }


    @Override
    public Set<Order> findAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}