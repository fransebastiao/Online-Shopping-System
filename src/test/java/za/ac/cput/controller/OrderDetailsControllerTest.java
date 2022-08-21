package za.ac.cput.controller;
/*
 Online-Shopping-System
  OrderDetailsControllertest
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
import za.ac.cput.domain.OrderDetails;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.OrderDetailsFactory;
import za.ac.cput.factory.ProductFactory;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class OrderDetailsControllerTest {


    @LocalServerPort
    private int port;

    @Autowired
    private OrderDetailsController controller;
    @Autowired private TestRestTemplate restTemplate;

    private OrderDetails order;
    private Product product;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);

        this.product = ProductFactory.createProduct("rice","R","R12");

        this.order = OrderDetailsFactory.createOrderDetails(Integer.parseInt("1"),"R12","R12",Integer.parseInt("1")
        ,product);
        this.baseUrl = "http://localhost:" + this.port + "/online-shopping-system/orderDetails/";
    }



    @Test
    void a_save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<OrderDetails> response = this.restTemplate
                .postForEntity(url, this.order, OrderDetails.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );

    }


    @Test
    void b_read() {
        String url = baseUrl + "read/" + this.order.getOrderDetailID();
        System.out.println(url);
        ResponseEntity<OrderDetails> response = this.restTemplate.getForEntity(url, OrderDetails.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }


    @Test
    void c_delete() {
        String url = baseUrl + "delete/" + this.order.getOrderDetailID();
        System.out.println(url);
        this.restTemplate.delete(url);
    }


    @Test
    void d_findAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<OrderDetails []> response =
                this.restTemplate.getForEntity(url, OrderDetails[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(0, response.getBody().length)
        );
    }
}