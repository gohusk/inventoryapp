package com.inventory.item;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.net.URL;

import io.restassured.RestAssured;
import javafx.application.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WebAppConfiguration
public class InventoryControllerIT {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    public void getInventoryItems() throws Exception {

        this.base = new URL("http://localhost:" + port + "/api/allinventory");
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
        RestAssured.basePath = "/api/allinventory";

        ResponseEntity<String> response = template.getForEntity(base.toString(),
                String.class);

        assertThat(response.getStatusCode().value(), equalTo(200));
        System.out.println();
    }
}