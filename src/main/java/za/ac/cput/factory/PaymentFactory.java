package za.ac.cput.factory;
/*
Online Shopping System
Lihle Langa 217181147
 */
import za.ac.cput.domain.Payment;
import za.ac.cput.util.GenericHelper;

import java.util.UUID;

public class PaymentFactory {
    public static Payment CreatePayment(String paymentId, String paymentDate, String paymentTime, String paymentTotal, String paymentDetails){

        String Payment = UUID.randomUUID().toString();
        if(GenericHelper.isNullorEmpty(paymentId) || GenericHelper.isNullorEmpty(paymentDate))
            return null;

        return new Payment.Builder().setPaymentId(paymentId)
                .setPaymentDate(paymentDate)
                .setPaymentTime(paymentTime)
                .setPaymentTotal(paymentTotal)
                .setPaymentDetails(paymentDetails)
                .build();

    }
}
