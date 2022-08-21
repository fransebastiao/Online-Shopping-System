package za.ac.cput.controller;
/*
UserRoleControllerTest.java
This is a controller test class for User Role
Siphelele Nyathi 218334028
21.08.2022
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.User;
import za.ac.cput.domain.UserRole;
import za.ac.cput.factory.UserRoleFactory;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserRoleControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private UserRoleController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    private UserRole role;
    private String baseUrl;

    @BeforeEach
    void setUp()
    {
        assertNotNull(controller);
        role = UserRoleFactory.createRole("Administrator");
        this.baseUrl = "http://localhost:" + this.port + "online-shopping-system/role/";
    }

    @Order(1)
    @Test
    void save(){
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<User> response = this.restTemplate
                .postForEntity(url, this.role, User.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody()));
    }

    @Order(2)
    @Test
    void read(){
        String url = baseUrl + "read/" + this.role.getRoleId();
        System.out.println(url);
        ResponseEntity<UserRole> response = this.restTemplate.getForEntity(url, UserRole.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Order(4)
    @Test
    void delete(){
        String url = baseUrl + "delete/" + this.role.getRoleId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    @Order(3)
    @Test
    void findAll(){
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<UserRole[]> response =
                this.restTemplate.getForEntity(url, UserRole[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(0, response.getBody().length)
        );
    }
}