package com.junu.freitag.telegram.bot

import com.junu.freitag.property.BotProperties
import com.junu.freitag.telegram.command.TelegramCommand
import com.junu.freitag.telegram.handler.CommandHandler
import mu.KotlinLogging
import org.springframework.stereotype.Component
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.Update

@Component
class FreitagTelegramBot(
        private val botProperties: BotProperties,
        private val messageHandler: CommandHandler
) : TelegramLongPollingBot() {

    private val log = KotlinLogging.logger {}

    override fun onUpdateReceived(nullableUpdate: Update?) {
        val update: Update = checkNotNull(nullableUpdate)

        val receivedMessage: Message = update.message

        log.info { "received Message : $receivedMessage" }

        val command = TelegramCommand.findByMessage(receivedMessage.text)

        //TODO("handle Command should be implement")

    }

    override fun getBotUsername(): String = botProperties.username

    override fun getBotToken(): String = botProperties.token
}