package za.ac.cput.controller;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Login;
import za.ac.cput.factory.LoginFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class LoginControllerTest {

    @LocalServerPort
    private int port;

    @Autowired private LoginController controller;
    @Autowired private TestRestTemplate restTemplate;

    private Login login;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.login = LoginFactory.createLogin(" user45@gmail.com", " User1234!");
        this.baseUrl = "http://localhost:" + this.port + "/online-shopping-system/account/";
    }
    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Login> response = this.restTemplate
                .postForEntity(url, this.login, Login.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(2)
    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.login.getUserEmail();
        System.out.println(url);
        this.restTemplate.delete(url);

    }
    @Order(3)
    @Test
    void read() {
        String url = baseUrl + "read/" + this.login.getUserEmail();
        System.out.println(url);
        ResponseEntity<Login> response = this.restTemplate.getForEntity(url, Login.class);
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
        ResponseEntity<Login []> response =
                this.restTemplate.getForEntity(url, Login[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(0, response.getBody().length)
        );
    }
}
