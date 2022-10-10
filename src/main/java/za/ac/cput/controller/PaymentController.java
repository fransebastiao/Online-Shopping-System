package za.ac.cput.controller;

/*
Online Shopping System
Lihle Langa 217181147
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Payment;
import za.ac.cput.service.PaymentService;
import javax.validation.Valid;
import java.util.Set;


@RestController
@RequestMapping("online-shopping-system/payment")
@Slf4j
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("save")
    public ResponseEntity<Payment> save(@Valid @RequestBody Payment payment){
        Payment save = this.paymentService.save(payment);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request{}", id);
        this.paymentService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("read/{id}")
    public ResponseEntity<Payment> read(@PathVariable String id){
        log.info("Read request: {}", id);
        Payment payment = this.paymentService.read(id);
        return ResponseEntity.ok(payment);
    }
    @GetMapping("all")
    public ResponseEntity<Set<Payment>> findAll(){
        Set<Payment> payment = this.paymentService.findAll();
        return ResponseEntity.ok(payment);
    }


}
