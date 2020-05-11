package com.junu.freitag.telegram.handler

import com.junu.freitag.telegram.bot.FreitagTelegramSender
import com.junu.freitag.user.entity.User
import com.junu.freitag.user.service.UserService
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Message

@Component
class StartCommandHandler(private val userService: UserService, private val freitagTelegramSender: FreitagTelegramSender) : CommandHandler {
    override fun handle(message: Message, user: User) {

        freitagTelegramSender.execute(SendMessage(user.telegramId.toString(), "Hello World!"))

    }

}
