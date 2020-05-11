package com.junu.freitag.telegram.bot

import com.junu.freitag.global.property.BotProperties
import org.springframework.stereotype.Component
import org.telegram.telegrambots.bots.DefaultAbsSender
import org.telegram.telegrambots.bots.DefaultBotOptions
import org.telegram.telegrambots.meta.ApiContext

@Component
class FreitagTelegramSender(private val botProperties: BotProperties) : DefaultAbsSender(ApiContext.getInstance(DefaultBotOptions::class.java)) {
    override fun getBotToken(): String = botProperties.token
}