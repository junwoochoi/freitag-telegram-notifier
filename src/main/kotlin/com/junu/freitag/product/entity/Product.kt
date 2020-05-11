package com.junu.freitag.product.entity

import com.junu.freitag.global.entity.BaseEntity
import com.junu.freitag.global.entity.BaseEntityClass
import com.junu.freitag.product.table.Products
import org.jetbrains.exposed.dao.id.EntityID

class Product(id: EntityID<Long>) : BaseEntity(id, Products) {
    companion object : BaseEntityClass<Product>(Products)

    var productName by Products.productName
    var productId by Products.productId
}