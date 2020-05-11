package com.junu.freitag.telegram.handler

import com.junu.freitag.telegram.command.TelegramCommand
import org.springframework.stereotype.Component

@Component
class HandlerFactory() {
    fun createFromInput(input: String): CommandHandler {
        return when (TelegramCommand.findByMessage(input)) {
            TelegramCommand.START -> StartCommandHandler()
            TelegramCommand.UNKNOWN_COMMAND -> UnknownCommandHandler()
            else -> UnknownCommandHandler()
        }
    }

}