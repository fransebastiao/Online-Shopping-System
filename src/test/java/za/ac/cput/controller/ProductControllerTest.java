//25.10.2022
package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.ProductFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ProductController controller;
    @Autowired private TestRestTemplate restTemplate;

    private Product product;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.product = ProductFactory.createProduct("101","Hammer","Construction tool","R300");
        this.baseUrl = "http://localhost:" + this.port + "/online-shopping-system/product/";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Product> response = this.restTemplate
                .withBasicAuth("admin-user", "65ff7492d30")
                .postForEntity(url, this.product, Product.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(3)
    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.product.getProductID();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    @Order(2)
    @Test
    void readId() {
        String url = baseUrl + "read/" + this.product.getProductID();
        System.out.println(url);
        ResponseEntity<Product> response = this.restTemplate
                .withBasicAuth("admin-user", "65ff7492d30")
                .getForEntity(url, Product.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Order(4)
    @Test
    void findAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Product []> response =
                this.restTemplate
                        .withBasicAuth("admin-user", "65ff7492d30")
                        .getForEntity(url, Product[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(7, response.getBody().length)
        );
    }
}