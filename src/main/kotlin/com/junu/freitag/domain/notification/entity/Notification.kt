package com.junu.freitag.domain.notification.entity

import com.junu.freitag.domain.notification.table.Notifications
import com.junu.freitag.domain.product.entity.Product
import com.junu.freitag.domain.stock.table.Stocks
import com.junu.freitag.domain.user.entity.User
import com.junu.freitag.domain.user.table.Users
import com.junu.freitag.global.entity.BaseEntity
import com.junu.freitag.global.entity.BaseEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class Notification(id: EntityID<Long>) : BaseEntity(id, Notifications) {
    companion object : BaseEntityClass<Notification>(Notifications)

    var user by User referencedOn Notifications.user
    var product by Product referencedOn Notifications.product

}