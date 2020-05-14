package com.junu.freitag.global.telegram.command

enum class TelegramCommand(val commandInput: String) {
    START("/start"),
    ADD_PRODUCT("/알림추가"),
    LIST_PRODUCT("/알림조회"),
    UNKNOWN_COMMAND("");

    companion object {
        fun findByMessage(input: String): TelegramCommand {
            return values().find { input.startsWith(it.commandInput) } ?: UNKNOWN_COMMAND
        }
    }
}