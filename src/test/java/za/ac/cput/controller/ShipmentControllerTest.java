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
import za.ac.cput.domain.Shipment;
import za.ac.cput.factory.ShipmentFactory;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ShipmentControllerTest
{
    @LocalServerPort
    private int port;

    @Autowired
    private ShipmentController controller;
    @Autowired private TestRestTemplate restTemplate;
    private Shipment shipment;
    private String baseUrl;

    @BeforeEach
    void setUp()
    {
        assertNotNull(controller);
        this.shipment = ShipmentFactory.build("102500", 65454,"Tshepang" ,"Y39 Tafa Street Site B"
                , 2158987, 2464, "12/Aug/2022", "12:00 pm");
        this.baseUrl = "http://localhost:" + this.port + "/schoolmanagement/shipment/";
    }

    @Order(1)
    @Test
    void save()
    {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Shipment> response = this.restTemplate
                .postForEntity(url, this.shipment, Shipment.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertNotNull(response.getBody()));
    }
    @Order(3)
    @Test
    void delete()
    {
        String url = baseUrl + "delete/" + this.shipment.getShipmentId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }
    @Order(2)
    @Test
    void read()
    {

        String url = baseUrl + "read/" + this.shipment.getShipmentId();
        System.out.println(url);
        ResponseEntity<Shipment> response = this.restTemplate.getForEntity(url, Shipment.class);
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
        ResponseEntity<Shipment[]> response =
                this.restTemplate.getForEntity(url, Shipment[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(0, response.getBody().length));
    }
}