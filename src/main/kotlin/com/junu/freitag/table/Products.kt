package com.junu.freitag.table

object Products : BaseTable() {
    val productName = varchar("product_name", 100)
    val productId = varchar("product_id", 50)
}