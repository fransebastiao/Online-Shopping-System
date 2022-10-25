/*
 * shoppingCart
 * Online-Shopping-System
 * 216217717
 * //25.10.2022
 * */
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.ShoppingCart;
import za.ac.cput.repository.IShoppingCartRepository;
import za.ac.cput.service.ShoppingCartService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final IShoppingCartRepository repository;

    @Autowired
    public ShoppingCartServiceImpl(IShoppingCartRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        return this.repository.save(shoppingCart);
    }

    @Override
    public ShoppingCart read(String s) {
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
    public Set<ShoppingCart> findAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}

