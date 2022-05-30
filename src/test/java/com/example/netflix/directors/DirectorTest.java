package com.example.netflix.directors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class DirectorTest {

  @Autowired private WebTestClient webTestClient;

  @Autowired private DirectorRepository directorRepository;

  @Test
  void shouldObtainADirectorsList() {
    webTestClient.get()
                 .uri("/director")
                 .exchange()
                 .expectStatus().isOk()
                 .expectBody()
                 .jsonPath("$._embedded.director.length()").isEqualTo(20);
  }

  @Test
  void shouldObtainADirectorById() {
    webTestClient.get()
                 .uri("/director/1")
                 .exchange()
                 .expectStatus().isOk()
                 .expectBody()
                 .jsonPath("$.name").isEqualTo("Kirsten Johnson");
  }
}