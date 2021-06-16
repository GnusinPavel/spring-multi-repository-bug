package org.example.web

import org.springframework.boot.autoconfigure.*
import org.springframework.boot.autoconfigure.condition.*
import org.springframework.context.annotation.*

@Configuration
@ComponentScan
@ConditionalOnWebApplication
@EnableAutoConfiguration
open class WebConfiguration