package za.ac.cput.controller;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Login;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.LoginFactory;
import za.ac.cput.factory.PaymentFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class PaymentControllerTest {
    @LocalServerPort
    private int port;
    @Autowired private PaymentController controller;
    @Autowired private TestRestTemplate restTemplate;
    private Payment payment;
    private String baseUrl;



    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.payment = PaymentFactory.CreatePayment("test Payment", " 8/21/2022", " 10h45", " R12000", " test Payment for the day");
        this.baseUrl = "http://localhost:" + this.port + "/online-shopping-system/account/";
    }
    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Payment> response = this.restTemplate
                .postForEntity(url, this.payment, Payment.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }
    @Order(2)
    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.payment.getPaymentId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }
    @Order(3)
    @Test
    void read() {
        String url = baseUrl + "read/" + this.payment.getPaymentId();
        System.out.println(url);
        ResponseEntity<Payment> response = this.restTemplate.getForEntity(url, Payment.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }
    @Order(4)
    @Test
    void findAll() { String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Payment []> response =
                this.restTemplate.getForEntity(url, Payment[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(0, response.getBody().length)
        );

    }
}