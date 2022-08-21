package za.ac.cput.service.impl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;


@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class PaymentServiceImplTest {
    private static final Payment payment1 = PaymentFactory.CreatePayment("first payment", "11/08/2018", "13h45", "R45000", " repairs payment");
    private static final Payment payment2 = PaymentFactory.CreatePayment(" second payment", " 22/10/1998", " 20hoo", " R30000", " school fees");

    @Autowired
    private PaymentServiceImpl service;

    @Test
    void save() {
        System.out.println("Saved Payments: ");
        Payment saved1 = service.save(payment1);
        assertNotNull(saved1);
        System.out.println(saved1);

        Payment saved2 = service.save(payment2);
        assertNotNull(saved2);
        System.out.println(saved2);
    }

    @Test
    void read() {
        Payment read = service.read(payment1.getPaymentId());
        assertEquals(read.getPaymentId(), payment1.getPaymentId());
        System.out.println("Show payment: " + read);
    }

    @Test
    void findAll() {
        System.out.println("Show all payments");
        System.out.println(service.findAll());
    }

    @Test
    void delete() {
        boolean success = service.delete(payment1.getPaymentId());
        assertTrue(success);
        System.out.println("Delete payment: " + success);
    }
}