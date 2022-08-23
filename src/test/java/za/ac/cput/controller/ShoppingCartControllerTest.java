package za.ac.cput.controller;
/*
 * Online-Shopping-System
 * Tshepang Molefe
 * 216217717
 * 10/04/2022
 */
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.ShoppingCart;
import za.ac.cput.factory.ShoppingCartFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ShoppingCartControllerTest

{

    @LocalServerPort
    private int port;

    @Autowired
    private ShoppingCartController controller;
    @Autowired private TestRestTemplate restTemplate;

    private ShoppingCart shoppingCart;
    private String baseUrl;

    @BeforeEach
    void setUp()
    {
        assertNotNull(controller);
        this.shoppingCart = ShoppingCartFactory.build("6421081", 56554,45651,"24/Aus/2022");
        this.baseUrl = "http://localhost:" + this.port + "/schoolmanagement/ShoppingCart/";
    }
    @Order(1)
    @Test
    void save()
    {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<ShoppingCart> response = this.restTemplate
                .postForEntity(url, this.shoppingCart, ShoppingCart.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }
    @Order(3)
    @Test
    void delete()
    {
        String url = baseUrl + "delete/" + this.shoppingCart.getCartId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }
    @Order(2)
    @Test
    void read()
    {
        String url = baseUrl + "read/" + this.shoppingCart.getCartId();
        System.out.println(url);
        ResponseEntity<ShoppingCart> response = this.restTemplate.getForEntity(url, ShoppingCart.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody()));
    }
    @Order(4)
    @Test
    void findAll()
    {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<ShoppingCart[]> response =
                this.restTemplate.getForEntity(url, ShoppingCart[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(0, response.getBody().length));
    }
}