package org.example

import org.example.general.*
import org.example.web.*
import org.springframework.boot.*
import org.springframework.boot.builder.*

class Application

fun main(args: Array<String>) {
    SpringApplicationBuilder(GeneralConfiguration::class.java)
        .web(WebApplicationType.NONE)
        .run(*args)
        .also {
            SpringApplicationBuilder(WebConfiguration::class.java)
                .parent(it)
                .web(WebApplicationType.SERVLET)
                .run(*args)
        }
}