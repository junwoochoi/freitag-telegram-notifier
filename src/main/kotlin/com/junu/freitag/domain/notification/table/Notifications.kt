package com.junu.freitag.domain.notification.table

import com.junu.freitag.domain.product.table.Products
import com.junu.freitag.domain.user.table.Users
import com.junu.freitag.global.table.BaseTable

object Notifications : BaseTable("notifications") {
    val user = reference("fk_user_id", Users)
    val product = reference("fk_product_id", Products)
}