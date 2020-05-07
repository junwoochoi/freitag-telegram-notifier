package com.junu.freitag.entity

import com.junu.freitag.table.ProductStocks
import org.jetbrains.exposed.dao.id.EntityID

class ProductStock(id: EntityID<Long>) : BaseEntity(id, ProductStocks) {
    companion object : BaseEntityClass<ProductStock>(ProductStocks)

    var stockId by ProductStocks.stockId
    var imageUrl by ProductStocks.imageUrl
    var color by ProductStocks.color
    var exists by ProductStocks.exists

    fun soldOut() {
        this.exists = false
    }
}