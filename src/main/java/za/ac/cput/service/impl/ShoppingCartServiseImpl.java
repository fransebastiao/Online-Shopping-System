/*
* shoppingCart
* Online-Shopping-System
* 216217717
* 12/08/2022
* */
package za.ac.cput.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.ShoppingCart;
import za.ac.cput.repository.ShoppingCartRepository;
import za.ac.cput.service.ShoppingCartServise;
import java.util.Set;
import java.util.stream.Collectors;

@Service

public class ShoppingCartServiseImpl implements ShoppingCartServise
{
    private final ShoppingCartRepository repository;

    @Autowired
    public ShoppingCartServiseImpl(ShoppingCartRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart)
    {
        return this.repository.save(shoppingCart);
    }

    @Override
    public ShoppingCart read(String id)
    {
        return this.repository.findById(id).orElse(null);

    }


    @Override
    public Set<ShoppingCart> findAll()
    {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public boolean delete(String id)
    {
        if (this.repository.existsById(id))
        {
            this.repository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteById(String id)
    {
        return false;
    }


}

