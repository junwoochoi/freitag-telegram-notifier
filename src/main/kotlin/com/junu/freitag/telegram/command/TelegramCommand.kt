package com.junu.freitag.telegram.command

enum class TelegramCommand(
        private val commandInput: String
) {
    START("/start"),
    ADD_PRODUCT("/add"),
    LIST_PRODUCT("/list"),
    UNKNOWN_COMMAND("");

    companion object {
        fun findByMessage(input: String): TelegramCommand {
            val emptySpaceDelimiter = " "
            val firstPartOfSplit = input.split(emptySpaceDelimiter)[0]
            return values().find { it.commandInput == firstPartOfSplit } ?: UNKNOWN_COMMAND
        }
    }
}