package com.junu.freitag.global.telegram.handler

import com.junu.freitag.global.telegram.bot.FreitagTelegramSender
import com.junu.freitag.global.telegram.command.TelegramCommand
import com.junu.freitag.domain.user.entity.User
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow

@Component
class StartCommandHandler(private val freitagTelegramSender: FreitagTelegramSender) : CommandHandler {
    override fun handle(message: Message, user: User) {
        val greetingMessage = """
            FREITAG 알리미에 오신 걸 환영합니다.
            아래 버튼 중 필요하신 기능을 클릭해주세요 :D
        """.trimIndent()


        val sendMessage = SendMessage(user.telegramId.toString(), greetingMessage)

        val addButton = KeyboardRow()
        addButton.add(TelegramCommand.ADD_PRODUCT.commandInput)

        val listButton = KeyboardRow()
        listButton.add(TelegramCommand.LIST_PRODUCT.commandInput)

        sendMessage.replyMarkup = ReplyKeyboardMarkup(listOf(addButton, listButton))

        freitagTelegramSender.execute(sendMessage)
    }

}
