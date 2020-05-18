package com.junu.freitag.domain.product.repository

import com.junu.freitag.domain.product.entity.Product
import com.junu.freitag.domain.product.table.Products
import org.springframework.stereotype.Repository

@Repository
class ProductRepository {
    fun findAll() = Product.all().toList()
    fun findByProductId(productId: String): Product? = Product.find { Products.productId eq productId }.firstOrNull()


}
