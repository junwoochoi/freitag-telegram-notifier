package com.junu.freitag.entity

import com.junu.freitag.table.Products
import org.jetbrains.exposed.dao.id.EntityID

class Product(id: EntityID<Long>) : BaseEntity(id, Products) {
    companion object : BaseEntityClass<Product>(Products)

    var productName by Products.productName
    var productId by Products.productId
}