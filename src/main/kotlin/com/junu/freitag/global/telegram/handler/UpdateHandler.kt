package com.junu.freitag.global.telegram.handler

import com.junu.freitag.global.aop.UserBasicInfo
import com.junu.freitag.global.exception.UserNotExistException
import com.junu.freitag.domain.user.service.UserService
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.Update

@Component
class UpdateHandler(private val handlerFactory: HandlerFactory,
                    private val userService: UserService) {


    @UserBasicInfo
    @Transactional
    fun handle(update: Update) {
        val receivedMessage: Message = update.message

        val user = userService.findByTelegramId(receivedMessage.from.id)
                ?: throw UserNotExistException(receivedMessage.from.id)

        val commandHandler = handlerFactory.createFromInput(receivedMessage.text)

        commandHandler.handle(message = receivedMessage, user = user)
    }

}