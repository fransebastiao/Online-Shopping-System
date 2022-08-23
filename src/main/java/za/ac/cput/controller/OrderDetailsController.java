package za.ac.cput.controller;
/*
 Online-Shopping-System
  OrderDetailsController
 Author: Edvalter da Costa Jamba (220446571)
 Date:18 August 2022
*/
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.OrderDetails;
import za.ac.cput.service.OrderDetailsService;


import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("online-shopping-system/orderDetails")
@Slf4j
public class OrderDetailsController {



    private final OrderDetailsService orderDetailsservice;

    @Autowired
    public OrderDetailsController(OrderDetailsService orderdetailsservice)
    {
        this.orderDetailsservice = orderdetailsservice;
    }

    @PostMapping("save")
    public ResponseEntity<OrderDetails> save(@Valid @RequestBody OrderDetails orderdetails){
        OrderDetails save = this.orderDetailsservice.save(orderdetails);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request{}", id);
        this.orderDetailsservice.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<OrderDetails> read(@PathVariable String id){
        log.info("Read request: {}", id);
        OrderDetails orderdetails = this.orderDetailsservice.read(id);
        return ResponseEntity.ok(orderdetails);
    }


    @GetMapping("all")
    public ResponseEntity<Set<OrderDetails>> findAll(){
        Set<OrderDetails> orderedetails = this.orderDetailsservice.findAll();
        return ResponseEntity.ok(orderedetails);
    }




}
