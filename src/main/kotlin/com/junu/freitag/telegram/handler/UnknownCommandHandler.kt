package com.junu.freitag.telegram.handler

import com.junu.freitag.entity.User
import org.telegram.telegrambots.meta.api.objects.Message

class UnknownCommandHandler : CommandHandler {
    override fun handle(message: Message, user: User) {
        TODO("Not yet implemented")
    }

}
