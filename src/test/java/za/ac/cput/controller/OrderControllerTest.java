package za.ac.cput.controller;
/*
 Online-Shopping-System
  OrderControllertest
 Author: Edvalter da Costa Jamba (220446571)
 Date:18 August 2022
*/
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
import za.ac.cput.factory.OrderFactory;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class OrderControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private OrderController controller;
    @Autowired private TestRestTemplate restTemplate;

    private Order order;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.order = OrderFactory.createOrder("1","18th of August, 2022",
                "on the way" ,"Edvalter","cape", Integer.parseInt("087373999"));
        this.baseUrl = "http://localhost:" + this.port + "/online-shopping-system/order/";
    }


    @Test
    void a_save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Order> response = this.restTemplate
                .postForEntity(url, this.order, Order.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );

    }


    @Test
    void b_read() {
        String url = baseUrl + "read/" + this.order.getOrderID();
        System.out.println(url);
        ResponseEntity<Order> response = this.restTemplate.getForEntity(url, Order.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }


    @Test
    void c_delete() {
        String url = baseUrl + "delete/" + this.order.getOrderID();
        System.out.println(url);
        this.restTemplate.delete(url);
    }


    @Test
    void d_findAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Order []> response =
                this.restTemplate.getForEntity(url, Order[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(0, response.getBody().length)
        );
    }
}