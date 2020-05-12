package com.junu.freitag

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.telegram.telegrambots.ApiContextInitializer

@SpringBootApplication
@EnableFeignClients
class FreitagApplication

fun main(args: Array<String>) {
    ApiContextInitializer.init()

    runApplication<FreitagApplication>(*args)
}
