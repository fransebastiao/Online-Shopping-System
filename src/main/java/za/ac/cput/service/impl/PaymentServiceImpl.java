/*
Online Shopping System
Lihle Langa 217181147
//25.10.2022
 */
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Payment;
import za.ac.cput.repository.IPaymentRepository;
import za.ac.cput.service.PaymentService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final IPaymentRepository repository;

    @Autowired
    public PaymentServiceImpl(IPaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Payment save(Payment payment) {
        return this.repository.save(payment);
    }

    @Override
    public Payment read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(String id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Set<Payment> findAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}

