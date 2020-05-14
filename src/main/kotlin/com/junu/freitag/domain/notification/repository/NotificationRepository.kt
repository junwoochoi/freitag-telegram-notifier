package com.junu.freitag.domain.notification.repository

import com.junu.freitag.domain.notification.entity.Notification
import com.junu.freitag.domain.product.entity.Product
import com.junu.freitag.domain.user.entity.User
import org.springframework.stereotype.Repository

@Repository
class NotificationRepository {
    fun create(user: User, product: Product) = Notification.new {
        this.user = user
        this.product = product
    }

}
