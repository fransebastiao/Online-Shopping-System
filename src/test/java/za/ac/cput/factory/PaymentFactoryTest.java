package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Payment;

import static org.junit.jupiter.api.Assertions.*;

class PaymentFactoryTest {

    @Test
    public void test(){
        Payment payment = PaymentFactory.CreatePayment("FirstPayment", "February", " TwelveThirty", "Three thousand rand", "FirstPayment, February, TwelveThirty, three Thousand Rand");
    }

}