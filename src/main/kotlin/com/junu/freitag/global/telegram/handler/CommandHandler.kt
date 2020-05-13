package com.junu.freitag.global.telegram.handler

import com.junu.freitag.domain.user.entity.User
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Message

@Component
interface CommandHandler {
    fun handle(message: Message, user: User)
}