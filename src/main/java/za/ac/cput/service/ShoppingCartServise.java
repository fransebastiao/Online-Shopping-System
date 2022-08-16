/*
* 216217717
* 12/08/2022
* */
package za.ac.cput.service;

import za.ac.cput.domain.ShoppingCart;

import java.util.List;

public interface ShoppingCartServise extends IService<ShoppingCart, String>
{
    List<ShoppingCart> findAll();
    void deleteById(String id);
}