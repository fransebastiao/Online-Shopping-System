//25.10.2022
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

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class  RegionControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private RegionController controller;
    @Autowired private TestRestTemplate restTemplate;

    private Region region;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.region = RegionFactory.createRegion("10201201",12,"Daniel Road",7780);
        this.baseUrl = "http://localhost:" + this.port + "/online-shopping-system/region/";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Region> response = this.restTemplate
                .withBasicAuth("admin-user", "65ff7492d30")
                .postForEntity(url, this.region, Region.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(3)
    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.region.getRegionId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    @Order(2)
    @Test
    void readId() {
        String url = baseUrl + "read/" + this.region.getRegionId();
        System.out.println(url);
        ResponseEntity<Region> response = this.restTemplate
                .withBasicAuth("admin-user", "65ff7492d30")
                .getForEntity(url, Region.class);
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
        ResponseEntity<Region []> response =
                this.restTemplate
                        .withBasicAuth("admin-user", "65ff7492d30")
                        .getForEntity(url, Region[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(1, response.getBody().length)
        );
    }
}