package com.junu.freitag.telegram.bot

import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.Update

@Component
class FreitagTelegramBot(
        @Value("\${bot.username}") private val username: String,
        @Value("\${bot.token}") private val token: String
) : TelegramLongPollingBot() {

    private val log = KotlinLogging.logger {}

    override fun onUpdateReceived(nullableUpdate: Update?) {
        val update: Update = checkNotNull(nullableUpdate)

        val receivedMessage: Message = update.message

        log.debug { "received Message : $receivedMessage" }
    }

    override fun getBotUsername(): String = this.token

    override fun getBotToken(): String = this.username
}