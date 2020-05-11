package com.junu.freitag.telegram.handler

import com.junu.freitag.entity.User
import com.junu.freitag.service.UserService
import org.telegram.telegrambots.meta.api.objects.Message

class StartCommandHandler(private val userService: UserService) : CommandHandler {
    override fun handle(message: Message, user: User) {


    }

}
