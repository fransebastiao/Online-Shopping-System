package za.ac.cput.repository;


import za.ac.cput.entity.Login;
import za.ac.cput.entity.Payment;

import java.util.ArrayList;

import java.util.List;

public class PaymentRepository implements IRepository<Payment, String>{

    private static PaymentRepository repo = null;

    private List<Payment> paymentList = null;


    private PaymentRepository(){

        paymentList = new ArrayList<Payment>();

    }



    public static PaymentRepository getRepo(){

        if(repo == null)

            repo = new PaymentRepository();

        return repo;

    }



    public List<Payment> getAll() {

        return paymentList;

    }



    @Override
    public Payment create(Payment payment) {

        boolean myOperation = paymentList.add(payment);

        if (!myOperation)

            return null;

        return payment;

    }



    @Override

    public Payment read(String paymentId) {

        for (Payment payment : paymentList)

            if (payment.getPaymentId().equals(paymentId))

                return payment;

        return null;

    }



    @Override

    public Payment update(Payment payment) {

        Payment oldPayment = read(payment.getPaymentId());

        if (oldPayment != null){

            paymentList.remove(oldPayment);

            paymentList.add(payment);

            return payment;

        }

        return null;

    }



    @Override

    public boolean delete(String paymentId) {

        Payment deletePayment = read(paymentId);

        if (deletePayment == null){

            throw new IllegalArgumentException("Failed to delete, there is nothing to delete");

        }

        paymentList.remove(paymentId);

        return true;

    }



}
