package com.junu.freitag.entity

import com.junu.freitag.table.Users
import org.jetbrains.exposed.dao.id.EntityID
import java.time.LocalDateTime

class User(id: EntityID<Long>) : BaseEntity(id, Users) {
    fun renewLastSentAt() {
        this.lastSentAt = LocalDateTime.now()
    }

    fun updateUsername(username: String = "") {
        if (username != this.username) {
            this.username = username
        }
    }

    companion object : BaseEntityClass<User>(Users)

    var username by Users.username
    var telegramId by Users.telegramId
    var lastSentAt by Users.lastSentAt
    var lastCommand by Users.lastCommand

}