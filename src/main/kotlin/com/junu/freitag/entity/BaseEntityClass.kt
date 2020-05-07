package com.junu.freitag.entity

import com.junu.freitag.table.BaseTable
import org.jetbrains.exposed.dao.EntityChangeType
import org.jetbrains.exposed.dao.EntityHook
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.toEntity
import java.time.LocalDateTime

abstract class BaseEntityClass<E : BaseEntity>(table: BaseTable) : LongEntityClass<E>(table) {
    init {
        EntityHook.subscribe { action ->
            if (action.changeType == EntityChangeType.Updated) {
                try {
                    action.toEntity(this)?.modifiedAt = LocalDateTime.now()
                } catch (e: Exception) {
                    //nothing to do here
                }
            }
        }
    }
}