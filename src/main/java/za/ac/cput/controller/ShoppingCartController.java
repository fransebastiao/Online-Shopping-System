package za.ac.cput.controller;
/*
 * Online-Shopping-System
 * Tshepang Molefe
 * 216217717
 * 10/04/2022
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.ShoppingCart;
import za.ac.cput.service.ShoppingCartServise;
import java.util.Set;

@RestController
@RequestMapping("Online-Shopping-System/ ShoppingCart")
@Slf4j

public class ShoppingCartController
{
    private final ShoppingCartServise shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartServise shoppingCartService)
    {
        this.shoppingCartService = shoppingCartService;


    }
    @PostMapping("save")
        public ResponseEntity<ShoppingCart> save(@RequestBody ShoppingCart shoppingCart){
        ShoppingCart save = this.shoppingCartService.save(shoppingCart);
        return ResponseEntity.ok(save);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity <ShoppingCart> delete (@PathVariable String id  )
    {
        log.info("Read request: {}", id);
        this.shoppingCartService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}/{quality}, {dateAdded}")
        public ResponseEntity<ShoppingCart> read (@PathVariable String id)
    {
        log.info("Read request: {}", id);
        ShoppingCart shoppingCart = this.shoppingCartService.read(id);
        return ResponseEntity.ok(shoppingCart);
    }

    @GetMapping("all")
    public ResponseEntity<Set<ShoppingCart>> findAll()
    {
        Set<ShoppingCart> ShoppingCart = this.shoppingCartService.findAll();
        return ResponseEntity.ok(ShoppingCart);
    }
}
