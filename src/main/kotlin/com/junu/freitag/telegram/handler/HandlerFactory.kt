package com.junu.freitag.telegram.handler

import com.junu.freitag.telegram.command.TelegramCommand
import org.springframework.stereotype.Component

@Component
class HandlerFactory(
        private val startCommandHandler: StartCommandHandler,
        private val unknownCommandHandler: UnknownCommandHandler
) {
    fun createFromInput(input: String): CommandHandler {
        return when (TelegramCommand.findByMessage(input)) {
            TelegramCommand.START -> startCommandHandler
            TelegramCommand.UNKNOWN_COMMAND -> unknownCommandHandler
            else -> UnknownCommandHandler()
        }
    }

}