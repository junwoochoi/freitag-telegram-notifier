package com.junu.freitag.user.entity

import com.junu.freitag.global.entity.BaseEntity
import com.junu.freitag.global.entity.BaseEntityClass
import com.junu.freitag.user.table.Users
import org.jetbrains.exposed.dao.id.EntityID
import java.time.LocalDateTime


class User(id: EntityID<Long>) : BaseEntity(id, Users) {
    fun renewLastSentAt() {
        this.lastSentAt = LocalDateTime.now()
    }

    fun updateUsername(username: String?) {
        if (username != this.username) {
            this.username = username ?: ""
        }
    }

    companion object : BaseEntityClass<User>(Users)

    var username by Users.username
    var telegramId by Users.telegramId
    var lastSentAt by Users.lastSentAt
    var lastCommand by Users.lastCommand

}