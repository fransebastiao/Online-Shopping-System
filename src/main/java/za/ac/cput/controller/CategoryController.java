package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Category;
import za.ac.cput.factory.CategoryFactory;
import za.ac.cput.service.CategoryService;
import java.util.Set;

@RestController
@RequestMapping("online-shopping-system/category/")
@Slf4j
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping("save")
    public ResponseEntity<Category> save(@RequestBody Category category){
        log.info("Save request: {}", category);
        Category validatedCategory;
        try {
            validatedCategory = CategoryFactory.createCategory(category.getCategoryName(),category.getCategoryDescription());
        }catch(IllegalArgumentException e){
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Category save = categoryService.save(validatedCategory);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request{}", id);
        this.categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Category> readId(@PathVariable String id){
        log.info("Read request: {}", id);
        Category category = this.categoryService.read(id);
        return ResponseEntity.ok(category);
    }

    @GetMapping("all")
    public ResponseEntity<Set<Category>> findAll(){
        Set<Category> categories = this.categoryService.findAll();
        return ResponseEntity.ok(categories);
    }

}
