package com.junu.freitag.telegram.command

enum class TelegramCommand(
        private val commandInput: String
) {
    START("/start");

    companion object {
        fun findByMessage(input: String): TelegramCommand {
            val telegramCommand = values().find { it.commandInput == input }

            return checkNotNull(telegramCommand, { "존재하지 않는 명령어 입니다." })
        }
    }
}