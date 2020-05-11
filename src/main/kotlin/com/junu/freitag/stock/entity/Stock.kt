package com.junu.freitag.stock.entity

import com.junu.freitag.global.entity.BaseEntity
import com.junu.freitag.global.entity.BaseEntityClass
import com.junu.freitag.product.entity.Product
import com.junu.freitag.stock.table.Stocks
import org.jetbrains.exposed.dao.id.EntityID


class Stock(id: EntityID<Long>) : BaseEntity(id, Stocks) {
    companion object : BaseEntityClass<Stock>(Stocks)

    var stockId by Stocks.stockId
    var imageUrl by Stocks.imageUrl
    var color by Stocks.color
    var exists by Stocks.exists
    var product by Product referencedOn Stocks.product

    fun soldOut() {
        this.exists = false
    }
}