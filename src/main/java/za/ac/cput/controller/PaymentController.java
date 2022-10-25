/*
Online Shopping System
Lihle Langa 217181147
//25.10.2022
 */
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;
import za.ac.cput.service.PaymentService;

import java.util.Set;

@RestController
@RequestMapping("online-shopping-system/payment/")
@Slf4j
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("save")
    public ResponseEntity<Payment> save(@RequestBody Payment payment) {
        log.info("Save request: {}", payment);
        Payment validatedPayment;
        try {
            validatedPayment = PaymentFactory.createPayment(payment.getPaymentId(), payment.getPaymentDate(), payment.getPaymentDetails(), payment.getPaymentTotal(), payment.getPaymentTime());
        } catch (IllegalArgumentException e) {
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Payment save = paymentService.save(validatedPayment);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Delete request{}", id);
        this.paymentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Payment> readId(@PathVariable String id) {
        log.info("Read request: {}", id);
        Payment payment = this.paymentService.read(id);
        return ResponseEntity.ok(payment);
    }

    @GetMapping("all")
    public ResponseEntity<Set<Payment>> findAll() {
        Set<Payment> payments = this.paymentService.findAll();
        return ResponseEntity.ok(payments);
    }

}