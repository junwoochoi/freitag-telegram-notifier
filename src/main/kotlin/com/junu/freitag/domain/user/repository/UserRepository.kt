package com.junu.freitag.domain.user.repository

import com.junu.freitag.global.telegram.command.TelegramCommand
import com.junu.freitag.domain.user.entity.User
import com.junu.freitag.domain.user.table.Users
import org.springframework.stereotype.Repository
import java.time.LocalDateTime


@Repository
class UserRepository {
    fun findByTelegramId(id: Int): User? =
            User.find {
                Users.telegramId eq id
            }.firstOrNull()

    fun create(telegramId: Int, username: String?) = User.new {
        this.telegramId = telegramId
        this.username = username ?: ""
        this.lastSentAt = LocalDateTime.now()
        this.lastCommand = TelegramCommand.UNKNOWN_COMMAND
    }


}
