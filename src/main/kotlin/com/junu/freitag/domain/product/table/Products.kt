package com.junu.freitag.domain.product.table

import com.junu.freitag.global.table.BaseTable

object Products : BaseTable("products") {
    val productUrlPrefix = varchar("product_url_prefix", 50)
    val productName = varchar("product_name", 100)
    val productId = varchar("product_id", 50)
}
