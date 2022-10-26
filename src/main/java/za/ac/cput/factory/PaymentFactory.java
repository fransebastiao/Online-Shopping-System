/*
Online Shopping System
Lihle Langa 217181147
//25.10.2022
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Payment;
import za.ac.cput.util.GenericHelper;

public class PaymentFactory {

    public static Payment createPayment(String paymentId, String paymentDate, String paymentTime, String paymentTotal, String paymentDetails) {
        GenericHelper.checkStringParam("paymentId", paymentId);
        GenericHelper.checkStringParam("paymentDate", paymentDate);
        GenericHelper.checkStringParam("paymentTime", paymentTime);
        GenericHelper.checkStringParam("paymentTotal", paymentTotal);
        GenericHelper.checkStringParam("paymentDetails", paymentDetails);

        return new Payment.Builder().setPaymentId(paymentId).setPaymentDate(paymentDate).setPaymentTime(paymentTime).setPaymentTotal(paymentTotal).setPaymentDetails(paymentDetails).build();


    }
}