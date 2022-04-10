package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Login;
import za.ac.cput.entity.Payment;
import za.ac.cput.factory.PaymentFactory;

import static org.junit.jupiter.api.Assertions.*;

class PaymentRepositoryTest {

    private static PaymentRepository repository = PaymentRepository.getRepo();

    private static Payment Payment= PaymentFactory.CreatePayment("First Payment", "12/08/2022", "12h30", "R3000", "First Payment, 12/08/2022, 12h30, R3000");


    @Test
    void create() {
        Payment payment = repository.create(Payment);
        assertEquals(Payment.getPaymentId(),payment.getPaymentId());
        System.out.println("Create: "+Payment);

    }

    @Test
    void read() {
        Payment paymentread = repository.read(Payment.getPaymentId());
        assertNotNull(paymentread);
        System.out.println("Read: " + paymentread);
    }

    @Test
    void update() {
        Payment TOupdated = new Payment.Builder().copy(Payment).setPaymentId("First Payment")
                .setPaymentDate("12/08/2022")
                .setPaymentTime("12h30")
                .setPaymentTotal("R3000")
                .build();
        assertNotNull(repository.update(TOupdated));
        System.out.println("Updated : "+TOupdated);

    }

    @Test
    void delete() {
        boolean deleted = repository.delete(Payment.getPaymentId());
        assertTrue(deleted);
        System.out.println("Deleted: "+deleted);
    }
    @Test
    void getAll(){
        System.out.println("Show all");
        System.out.println(repository.getAll());

    }
}