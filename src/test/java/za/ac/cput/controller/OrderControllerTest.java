//25.10.2022
package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderDetails;
import za.ac.cput.factory.OrderDetailsFactory;
import za.ac.cput.factory.OrderFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class  OrderControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private OrderController controller;
    @Autowired private TestRestTemplate restTemplate;

    private Order order;
    private OrderDetails orderDetails;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.orderDetails = OrderDetailsFactory.createOrderDetails(10, "R10","R3,000");
        this.order =  OrderFactory.createOrder("1212121","11/02/2022","In Progress", "Francis","Standfontein",273, orderDetails);
        this.baseUrl = "http://localhost:" + this.port + "/online-shopping-system/order/";
    }

    /*@Order(1)*/
    @Test
    void a_save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Order> response = this.restTemplate
                .withBasicAuth("admin-user", "65ff7492d30")
                .postForEntity(url, this.order, Order.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    /*@Order(3)*/
    @Test
    void c_delete() {
        String url = baseUrl + "delete/" + this.order.getOrderId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    /*@Order(2)*/
    @Test
    void b_readId() {
        String url = baseUrl + "read/" + this.order.getOrderId();
        System.out.println(url);
        ResponseEntity<Order> response = this.restTemplate
                .withBasicAuth("admin-user", "65ff7492d30")
                .getForEntity(url, Order.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    /*    @Order(4)*/
    @Test
    void d_findAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Order []> response =
                this.restTemplate
                        .withBasicAuth("admin-user", "65ff7492d30")
                        .getForEntity(url, Order[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(1, response.getBody().length)
        );
    }
}