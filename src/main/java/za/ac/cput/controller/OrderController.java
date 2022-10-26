/*
 Online-Shopping-System
  OrderController
 Author: Edvalter da Costa Jamba (220446571)
 //25.10.2022
*/
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.service.OrderService;

import java.util.Set;

@RestController
@RequestMapping("online-shopping-system/order/")
@Slf4j
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("save")
    public ResponseEntity<Order> save(@RequestBody Order order) {
        log.info("Save request: {}", order);
        Order validatedOrder;
        try {
            validatedOrder = OrderFactory.createOrder(order.getOrderId(),order.getOrderDate(), order.getOrderStatus(), order.getCustomerName(), order.getDeliveryAddress(), order.getContactNumber(), order.getDetails());
        } catch (IllegalArgumentException e) {
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Order save = orderService.save(validatedOrder);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Delete request{}", id);
        this.orderService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Order> readId(@PathVariable String id) {
        log.info("Read request: {}", id);
        Order order = this.orderService.read(id);
        return ResponseEntity.ok(order);
    }

    @GetMapping("all")
    public ResponseEntity<Set<Order>> findAll() {
        Set<Order> orders = this.orderService.findAll();
        return ResponseEntity.ok(orders);
    }

}