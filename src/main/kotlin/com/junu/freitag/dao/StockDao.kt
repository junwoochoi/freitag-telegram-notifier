package com.junu.freitag.dao

import com.junu.freitag.entity.Product
import com.junu.freitag.entity.Stock
import com.junu.freitag.table.Stocks.exists
import com.junu.freitag.table.Stocks.stockId
import org.jetbrains.exposed.sql.and
import org.springframework.stereotype.Repository

@Repository
class StockDao {

    fun create(stockId: String, color: String, imageUrl: String, product: Product): Stock =
            Stock.new {
                this.stockId = stockId
                this.color = color
                this.imageUrl = imageUrl
                this.product = product
            }

    fun findSoldOutStocks(searchedIds: List<String>): List<Stock> =
            Stock.find {
                stockId notInList (searchedIds) and
                        (exists eq true)
            }.toList()

    fun findMarkedExists(): List<Stock> = Stock.find { exists eq true }.toList()


}