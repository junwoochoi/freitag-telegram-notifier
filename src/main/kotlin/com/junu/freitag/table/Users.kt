package com.junu.freitag.table

import com.junu.freitag.telegram.command.TelegramCommand
import org.jetbrains.exposed.sql.`java-time`.datetime

object Users : BaseTable("users") {
    val username = varchar("username", 80)
    val telegramId = integer("telegram_id").uniqueIndex("unique_telegram_id")
    val lastSentAt = datetime("last_sent_at")
    val lastCommand = enumerationByName("last_command", 80, TelegramCommand::class)
}