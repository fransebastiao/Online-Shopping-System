package za.ac.cput.service.OrderService;
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

import java.util.List;
import java.util.Optional;

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
    public Order save(Order order)
    {
        return this.repository.save(order);
    }

    @Override
    public Optional<Order> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Order order)
    {
        this.repository.delete(order);

    }

    @Override
    public List<Order> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id)
    {

        repository.deleteById(id);
        Optional<Order> order = read(id);
        if (order.isPresent()) {
            delete(order.get());
        }

    }
}
