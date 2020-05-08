package com.junu.freitag.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "bot")
class BotProperties {
    lateinit var username: String
    lateinit var token: String
}
