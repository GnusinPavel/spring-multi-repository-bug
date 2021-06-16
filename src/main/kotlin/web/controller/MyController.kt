package org.example.web.controller

import org.springframework.web.bind.annotation.*

@RestController
class MyController {

    @GetMapping
    fun hello(@RequestParam name: String): String {
        return "Hello, $name!"
    }
}