/*
 * Online-Shopping-System
 * Tshepang Molefe
 * 216217717
 * //25.10.2022
 */
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.ShoppingCart;
import za.ac.cput.factory.ShoppingCartFactory;
import za.ac.cput.service.ShoppingCartService;

import java.util.Set;

@RestController
@RequestMapping("online-shopping-system/shoppingcart/")
@Slf4j
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("save")
    public ResponseEntity<ShoppingCart> save(@RequestBody ShoppingCart shoppingCart) {
        log.info("Save request: {}", shoppingCart);
        ShoppingCart validatedShoppingCart;
        try {
            validatedShoppingCart = ShoppingCartFactory.createShoppingCart(shoppingCart.getCartId(), shoppingCart.getProductId(), shoppingCart.getQuantity(), shoppingCart.getDateAdded());
        } catch (IllegalArgumentException e) {
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        ShoppingCart save = shoppingCartService.save(validatedShoppingCart);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Delete request{}", id);
        this.shoppingCartService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<ShoppingCart> readId(@PathVariable String id) {
        log.info("Read request: {}", id);
        ShoppingCart shoppingCart = this.shoppingCartService.read(id);
        return ResponseEntity.ok(shoppingCart);
    }

    @GetMapping("all")
    public ResponseEntity<Set<ShoppingCart>> findAll() {
        Set<ShoppingCart> shoppingCarts = this.shoppingCartService.findAll();
        return ResponseEntity.ok(shoppingCarts);
    }

}
