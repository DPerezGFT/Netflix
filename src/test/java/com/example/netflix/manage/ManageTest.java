package com.example.netflix.manage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class ManageTest {

  @Autowired private WebTestClient webTestClient;

  @Test
  void shouldObtainAStatusOk() {
    webTestClient.get()
                 .uri("/manage/health")
                 .exchange()
                 .expectStatus().isOk();
  }
}