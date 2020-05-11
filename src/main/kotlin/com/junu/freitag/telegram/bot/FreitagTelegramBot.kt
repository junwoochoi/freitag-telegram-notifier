package com.junu.freitag.telegram.bot

import com.junu.freitag.exception.UserNotExistException
import com.junu.freitag.property.BotProperties
import com.junu.freitag.service.UserService
import com.junu.freitag.telegram.handler.HandlerFactory
import mu.KotlinLogging
import org.springframework.stereotype.Component
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.Update

@Component
class FreitagTelegramBot(
        private val botProperties: BotProperties,
        private val handlerFactory: HandlerFactory,
        private val userService: UserService
) : TelegramLongPollingBot() {

    private val log = KotlinLogging.logger {}

    override fun onUpdateReceived(nullableUpdate: Update?) {
        val update: Update = checkNotNull(nullableUpdate)
        val receivedMessage: Message = update.message

        log.info { "received Message : $receivedMessage" }

        userService.renewUserData(from = receivedMessage.from)
        val user = userService.findByTelegramId(receivedMessage.from.id)
                ?: throw UserNotExistException(receivedMessage.from.id)

        val commandHandler = handlerFactory.createFromInput(receivedMessage.text)

        commandHandler.handle(message = receivedMessage, user = user)
    }

    override fun getBotUsername(): String = botProperties.username

    override fun getBotToken(): String = botProperties.token
}