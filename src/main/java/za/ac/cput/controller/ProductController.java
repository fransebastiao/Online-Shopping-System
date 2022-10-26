/*
 * ProductController.java
 * Author: Sharfaa Sedick Anthony 220041571
 * //25.10.2022
 * */
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.ProductFactory;
import za.ac.cput.service.ProductService;

import java.util.Set;

@RestController
@RequestMapping("online-shopping-system/product/")
@Slf4j
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("save")
    public ResponseEntity<Product> save(@RequestBody Product product){
        log.info("Save request: {}", product);
        Product validatedProduct;
        try {
            validatedProduct = ProductFactory.createProduct(product.getProductID(), product.getProductName(),product.getProdDescription(), product.getProdPrice());
        }catch(IllegalArgumentException e){
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Product save = productService.save(validatedProduct);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request{}", id);
        this.productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Product> readId(@PathVariable String id){
        log.info("Read request: {}", id);
        Product product = this.productService.read(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("all")
    public ResponseEntity<Set<Product>> findAll(){
        Set<Product> products = this.productService.findAll();
        return ResponseEntity.ok(products);
    }
}
