package com.example.netflix.categories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class CategoryTest {

  @Autowired private WebTestClient webTestClient;

  @Autowired private CategoryRepository categoryRepository;

  @Test
  void shouldObtainACategorysList() {
    webTestClient.get()
                 .uri("/category")
                 .exchange()
                 .expectStatus().isOk()
                 .expectBody()
                 .jsonPath("$._embedded.category.length()").isEqualTo(20);
  }

  @Test
  void shouldObtainACategoryById() {
    webTestClient.get()
                 .uri("/category/1")
                 .exchange()
                 .expectStatus().isOk()
                 .expectBody()
                 .jsonPath("$.name").isEqualTo("Documentaries");
  }
}