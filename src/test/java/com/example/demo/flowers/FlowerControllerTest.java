package com.example.demo.flowers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FlowerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetStatus() {
        ResponseEntity<String> response = restTemplate.getForEntity("/flowers/status", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Flower service is up and running!", response.getBody());
    }
}

