package com.example.apijavaspringboot;

import com.example.apijavaspringboot.model.Client;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("dev")
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientApiTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Order(1)
    void testAddClient() {

        Client client = new Client("Fulano",  20);

        ResponseEntity responseEntity = this.restTemplate.postForEntity("/client", client, Map.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(((LinkedHashMap) responseEntity.getBody()).get("id")).isNotNull();
    }

    @Test
    @Order(1)
    void testAddClient2() {

        Client client = new Client("João",  55);

        ResponseEntity responseEntity = this.restTemplate.postForEntity("/client", client, Map.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(((LinkedHashMap) responseEntity.getBody()).get("id")).isNotNull();
    }

    @Test
    @Order(2)
    void testGetClient() {

        Long id = 1L;

        ResponseEntity<Client> responseEntity = this.restTemplate.getForEntity("/client/" + id, Client.class, Map.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(responseEntity.getBody().getId()).isEqualTo(id);

    }

    @Test
    @Order(2)
    void testGetAllClient() {

        ResponseEntity<List> responseEntity = this.restTemplate.getForEntity("/client/all", List.class, Map.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(responseEntity.getBody().size()).isGreaterThan(0);

    }

    @Test
    @Order(3)
    void testFindClient() {

        Client client = new Client();

        client.setName("Fulano");

        ResponseEntity responseEntity = this.restTemplate.postForEntity("/client/find", client, List.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(((List) responseEntity.getBody()).size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    void testDeletelClient() {

        Long id = 2L;

        this.restTemplate.delete("/client/"+ id);

        ResponseEntity<Map> responseEntity = this.restTemplate.getForEntity("/client/" + id, Map.class, Map.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

        assertThat(responseEntity.getBody()).isNotNull();

    }
}
