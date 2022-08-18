package za.ac.cput.service;

/*
Online Shopping System
Lihle Langa 217181147
 */
import za.ac.cput.domain.Payment;

public interface PaymentService extends IService<Payment, String>{
    @Override
    boolean delete(String s);
}
