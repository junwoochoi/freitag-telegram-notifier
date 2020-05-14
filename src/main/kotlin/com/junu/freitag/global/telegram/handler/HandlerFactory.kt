package com.junu.freitag.global.telegram.handler

import com.junu.freitag.global.telegram.command.TelegramCommand
import org.springframework.stereotype.Component

@Component
class HandlerFactory(
        private val startCommandHandler: StartCommandHandler,
        private val unknownCommandHandler: UnknownCommandHandler,
        private val addNotificationCommandHandler: AddNotificationCommandHandler
) {
    fun createFromInput(input: String): CommandHandler {
        return when (TelegramCommand.findByMessage(input)) {
            TelegramCommand.START -> startCommandHandler
            TelegramCommand.UNKNOWN_COMMAND -> unknownCommandHandler
            TelegramCommand.ADD_PRODUCT -> addNotificationCommandHandler
            else -> unknownCommandHandler
        }
    }

}