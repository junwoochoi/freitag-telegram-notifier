package com.junu.freitag.table

object Stocks : BaseTable("stocks") {
    val stockId = varchar("stock_id", 30)
    val color = varchar("color", 50)
    val imageUrl = varchar("image_url", 300)
    val exists = bool("exists").default(true)
    val product = reference("fk_product_id", Products)
}