package com.junu.freitag.domain.product.entity

import com.junu.freitag.global.entity.BaseEntity
import com.junu.freitag.global.entity.BaseEntityClass
import com.junu.freitag.domain.product.table.Products
import org.jetbrains.exposed.dao.id.EntityID

class Product(id: EntityID<Long>) : BaseEntity(id, Products) {
    companion object : BaseEntityClass<Product>(Products)
    var productUrlPrefix by Products.productUrlPrefix
    var productName by Products.productName
    var productId by Products.productId
}