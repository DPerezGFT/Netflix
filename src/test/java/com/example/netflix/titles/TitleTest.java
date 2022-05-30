package com.example.netflix.titles;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class TitleTest {

  @Autowired private WebTestClient webTestClient;

  @Autowired private TitleRepository titleRepository;

  @Test
  void shouldObtainATitlesList() {
    webTestClient.get()
                 .uri("/title")
                 .exchange()
                 .expectStatus().isOk()
                 .expectBody()
                 .jsonPath("$._embedded.title.length()").isEqualTo(20);
  }

  @Test
  void shouldObtainATitleById() {
    webTestClient.get()
                 .uri("/title/1")
                 .exchange()
                 .expectStatus().isOk()
                 .expectBody()
                 .jsonPath("$.name").isEqualTo("Dick Johnson Is Dead");
  }
}