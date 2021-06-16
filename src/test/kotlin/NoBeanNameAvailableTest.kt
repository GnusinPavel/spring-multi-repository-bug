package org.example

import org.aspectj.lang.annotation.*
import org.example.general.*
import org.example.web.*
import org.junit.jupiter.api.*
import org.springframework.boot.*
import org.springframework.boot.builder.*
import org.springframework.test.web.reactive.server.*

class NoBeanNameAvailableTest {

    lateinit var webTestClient: WebTestClient

    @BeforeEach
    fun setup() {
        val generalContext = SpringApplicationBuilder(GeneralConfiguration::class.java)
            .web(WebApplicationType.NONE)
            .run()

        val childContext = SpringApplicationBuilder(WebConfiguration::class.java)
            .parent(generalContext)
            .web(WebApplicationType.SERVLET)
            .run()

        val port = childContext.environment.getProperty("local.server.port")!!.toInt()
        webTestClient = WebTestClient.bindToServer().baseUrl("http://localhost:$port").build()
    }

    @Test
    fun `should be ok, but don't`() {
        webTestClient.get()
            .uri("/?name=Mike")
            .exchange()
            .expectStatus().isOk
            .expectBody<String>().isEqualTo("Hello, Mike!")
    }
}