package za.ac.cput.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.ShoppingCart;
import za.ac.cput.repository.ShoppingCartRepository;
import za.ac.cput.service.ShoppingCartServise;

import java.util.List;
import java.util.Optional;

@Service

public class ShoppingCartServiseImpl implements ShoppingCartServise
{
    private final ShoppingCartRepository repository;
    @Autowired
    public ShoppingCartServiseImpl(ShoppingCartRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart)
    {
        return this.repository.save(shoppingCart);
    }

    @Override
    public Optional<ShoppingCart> read(String id)
    {
        return this.repository.findById(id);
    }

    @Override
    public void delete(ShoppingCart shoppingCart)
    {
        this.repository.delete(shoppingCart);
    }

    @Override
    public List<ShoppingCart> findAll()
    {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id)
    {
        repository.deleteById(id);
        Optional<ShoppingCart> ShoppingCart = read(id);
        if (ShoppingCart.isPresent()) {
            delete(ShoppingCart.get());
        }
    }
}

