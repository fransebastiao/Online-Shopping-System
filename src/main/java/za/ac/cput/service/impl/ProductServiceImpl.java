/*
 * ProductServiceImpl.java
 * Service Implementation class for Product
 * Author: Sharfaa Sedick Anthony 220041571
 * */

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Product;
import za.ac.cput.repository.IProductRepository;
import za.ac.cput.service.ProductService;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final IProductRepository repository;

    @Autowired
    public ProductServiceImpl(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product save(Product product) {
        return this.repository.save(product);
    }

    @Override
    public Product read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(String id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Set<Product> findAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
