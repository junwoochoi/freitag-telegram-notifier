package com.junu.freitag.telegram.handler

import com.junu.freitag.entity.User
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Message


@Component
class UnknownCommandHandler : CommandHandler {
    override fun handle(message: Message, user: User) {
        TODO("Not yet implemented")
    }

}
