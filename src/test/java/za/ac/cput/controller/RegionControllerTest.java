package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Region;
import za.ac.cput.factory.RegionFactory;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RegionControllerTest {
    @LocalServerPort
    private int port;

    @Autowired private AccountController controller;
    @Autowired private TestRestTemplate restTemplate;

    private Region region;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.region = RegionFactory.saveRegion(20,"Ellios road",3900);
        this.baseUrl = "http://localhost:" + this.port + "/online-shopping-system/region/";
    }

    @Order(1)
    @Test
    void save(){
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Region> response = this.restTemplate
                .postForEntity(url, this.region, Region.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(2)
    @Test
    void read(){
        String url = baseUrl + "read/" + this.region.getRegionId();
        System.out.println(url);
        ResponseEntity<Region> response = this.restTemplate.getForEntity(url, Region.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Order(3)
    @Test
    void delete(){
        String url = baseUrl + "delete/" + this.region.getRegionId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    @Order(4)
    @Test
    void findAll(){
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Region []> response =
                this.restTemplate.getForEntity(url, Region[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(0, response.getBody().length)
        );
    }
}