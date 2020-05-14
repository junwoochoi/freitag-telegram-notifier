package com.junu.freitag.global.telegram.handler

import com.junu.freitag.domain.notification.entity.Notification
import com.junu.freitag.domain.notification.service.NotificationService
import com.junu.freitag.domain.product.service.ProductService
import com.junu.freitag.global.telegram.bot.FreitagTelegramSender
import com.junu.freitag.domain.user.entity.User
import com.junu.freitag.global.telegram.command.TelegramCommand
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow


@Component
class AddNotificationCommandHandler(
        private val telegramSender: FreitagTelegramSender,
        private val productService: ProductService,
        private val notificationService: NotificationService) : CommandHandler {
    override fun handle(message: Message, user: User) {
        user.updateLastCommand(TelegramCommand.ADD_PRODUCT)

        val text = message.text
        val splitCommands = text.split(" ")

        if (splitCommands.size == 1) {
            val rows = productService.findAll()
                    .map { "${TelegramCommand.ADD_PRODUCT.commandInput} #${it.productId} ${it.productName}" }
                    .map {
                        val row = KeyboardRow()
                        row.add(it)
                        row
                    }.toList()

            val sendMessage = SendMessage(message.from.id.toLong(), "알림 등록을 원하시는 제품명을 선택해주세요.")
            sendMessage.replyMarkup = ReplyKeyboardMarkup(rows)

            telegramSender.execute(sendMessage)
            return
        }

        if (splitCommands[1].startsWith("#")) {
            val productId = splitCommands[1].substring(1).toLong()
            notificationService.create(productId, user)
            telegramSender.execute(SendMessage(message.from.id.toLong(), "[${splitCommands[2]}] 의 알림이 추가되었습니다."))
            return
        }
    }

}
