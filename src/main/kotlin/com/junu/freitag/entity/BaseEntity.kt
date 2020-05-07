package com.junu.freitag.entity

import com.junu.freitag.table.BaseTable
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID

abstract class BaseEntity(id: EntityID<Long>, table: BaseTable) : LongEntity(id) {
    val createdAt by table.createdAt
    var modifiedAt by table.modifiedAt
}
