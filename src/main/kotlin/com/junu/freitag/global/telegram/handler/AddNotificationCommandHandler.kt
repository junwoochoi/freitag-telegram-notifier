package com.junu.freitag.global.telegram.handler

import com.junu.freitag.global.telegram.bot.FreitagTelegramSender
import com.junu.freitag.domain.user.entity.User
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Message


@Component
class AddNotificationCommandHandler(
        private val telegramSender: FreitagTelegramSender) : CommandHandler {
    override fun handle(message: Message, user: User) {
        telegramSender.execute(SendMessage(message.from.id.toLong(), "지원하지 않는 명령어입니다. 다시 확인해주세요."))
    }

}
