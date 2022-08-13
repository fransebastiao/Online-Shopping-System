/*
 * CategoryServiceImpl.java
 * Service Implementation class for Category
 * Author: Sharfaa Sedick Anthony 220041571
 * */

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Category;
import za.ac.cput.repository.ICategoryRepository;
import za.ac.cput.service.CategoryService;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final ICategoryRepository repository;

    @Autowired
    public CategoryServiceImpl(ICategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category save(Category category) {
        return this.repository.save(category);
    }

    @Override
    public Category read(String s) {
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
    public Set<Category> findAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
