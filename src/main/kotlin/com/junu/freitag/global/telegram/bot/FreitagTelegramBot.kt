package com.junu.freitag.global.telegram.bot

import com.junu.freitag.global.property.BotProperties
import com.junu.freitag.global.telegram.handler.UpdateHandler
import org.springframework.stereotype.Component
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Update

@Component
class FreitagTelegramBot(
        private val botProperties: BotProperties,
        private val updateHandler: UpdateHandler
) : TelegramLongPollingBot() {

    override fun onUpdateReceived(nullableUpdate: Update?) {
        val update: Update = checkNotNull(nullableUpdate)
        updateHandler.handle(update)
    }

    override fun getBotUsername(): String = botProperties.username

    override fun getBotToken(): String = botProperties.token
}