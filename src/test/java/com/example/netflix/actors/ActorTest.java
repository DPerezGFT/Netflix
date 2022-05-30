package com.example.netflix.actors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class ActorTest {

  @Autowired private WebTestClient webTestClient;

  @Autowired private ActorRepository actorRepository;

  @Test
  void shouldObtainAActorsList() {
    webTestClient.get()
                 .uri("/actor")
                 .exchange()
                 .expectStatus().isOk()
                 .expectBody()
                 .jsonPath("$._embedded.actor.length()").isEqualTo(20);
  }

  @Test
  void shouldObtainAActorById() {
    webTestClient.get()
                 .uri("/actor/1")
                 .exchange()
                 .expectStatus().isOk()
                 .expectBody()
                 .jsonPath("$.name").isEqualTo("Ama Qamata");
  }
}