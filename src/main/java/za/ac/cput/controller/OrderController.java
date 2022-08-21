package za.ac.cput.controller;
/*
 Online-Shopping-System
  OrderController
 Author: Edvalter da Costa Jamba (220446571)
 Date:18 August 2022
*/


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Account;
import za.ac.cput.domain.Order;
import za.ac.cput.service.AccountService;
import za.ac.cput.service.OrderService;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("online-shopping-system/order")
@Slf4j
public class OrderController {

    private final OrderService orderservice;

    @Autowired
    public OrderController(OrderService orderservice)
    {
        this.orderservice = orderservice;
    }

    @PostMapping("save")
    public ResponseEntity<Order> save(@Valid @RequestBody Order order){
        Order save = this.orderservice.save(order);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request{}", id);
        this.orderservice.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Order> read(@PathVariable String id){
        log.info("Read request: {}", id);
        Order order = this.orderservice.read(id);
        return ResponseEntity.ok(order);
    }


    @GetMapping("all")
    public ResponseEntity<Set<Order>> findAll(){
        Set<Order> order = this.orderservice.findAll();
        return ResponseEntity.ok(order);
    }


}
