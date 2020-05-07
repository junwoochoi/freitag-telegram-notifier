package com.junu.freitag.table

object ProductStocks : BaseTable() {
    val stockId = varchar("stock_id", 30)
    val color = varchar("color", 50)
    val imageUrl = varchar("image_url", 300)
    val exists = bool("exists").default(true)
}