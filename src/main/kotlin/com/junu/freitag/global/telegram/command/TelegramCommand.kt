package com.junu.freitag.global.telegram.command

enum class TelegramCommand(val commandInput: String) {
    START("/start"),
    ADD_PRODUCT("/알림 추가"),
    LIST_PRODUCT("/알림 조회"),
    UNKNOWN_COMMAND("");

    companion object {
        fun findByMessage(input: String): TelegramCommand {
            val emptySpaceDelimiter = " "
            val firstPartOfSplit = input.split(emptySpaceDelimiter)[0]
            return values().find { it.commandInput == firstPartOfSplit } ?: UNKNOWN_COMMAND
        }
    }
}