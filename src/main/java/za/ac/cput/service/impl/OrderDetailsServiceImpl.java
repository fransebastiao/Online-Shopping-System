package za.ac.cput.service.impl;
/*
        Online-Shopping-System
        Services:OrderDetailsImpl
        Author: Edvalter da Costa Jamba (220446571)
        Date: 10 August 2022
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.OrderDetails;
import za.ac.cput.repository.OrderDetailsRpository;
import za.ac.cput.service.OrderDetailsService;

import java.util.Set;
import java.util.stream.Collectors;


@Service
public class OrderDetailsServiceImpl implements OrderDetailsService
{
    private final OrderDetailsRpository repository;

    @Autowired
    public OrderDetailsServiceImpl(OrderDetailsRpository repository)
    {
        this.repository = repository;
    }


    @Override
    public OrderDetails save(OrderDetails orderDetails) {
        return this.repository.save(orderDetails);
    }

    @Override
    public OrderDetails read(String s) {
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
    public Set<OrderDetails> findAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }


}
