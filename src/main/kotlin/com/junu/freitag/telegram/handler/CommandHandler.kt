package com.junu.freitag.telegram.handler

import com.junu.freitag.user.entity.User
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Message

@Component
interface CommandHandler {
    fun handle(message: Message, user: User)
}