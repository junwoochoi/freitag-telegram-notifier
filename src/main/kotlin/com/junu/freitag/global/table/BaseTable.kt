package com.junu.freitag.global.table

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.`java-time`.datetime
import java.time.LocalDateTime

abstract class BaseTable(name: String) : LongIdTable(name) {
    val createdAt = datetime("created_at").clientDefault { LocalDateTime.now() }
    val modifiedAt = datetime("modified_at").clientDefault { LocalDateTime.now() }
}
