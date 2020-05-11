package com.junu.freitag.repository

import com.junu.freitag.entity.User
import com.junu.freitag.table.Users
import com.junu.freitag.telegram.command.TelegramCommand
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class UserRepository {
    fun findByTelegramId(id: Int): User? =
            User.find {
                Users.telegramId eq id
            }.firstOrNull()

    fun create(telegramId: Int, username: String = "") = User.new {
        this.telegramId = telegramId
        this.username = username
        this.lastSentAt = LocalDateTime.now()
        this.lastCommand = TelegramCommand.UNKNOWN_COMMAND
    }


}
