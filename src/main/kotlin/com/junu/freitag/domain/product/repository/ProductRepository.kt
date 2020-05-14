package com.junu.freitag.domain.product.repository

import com.junu.freitag.domain.product.entity.Product
import org.springframework.stereotype.Repository

@Repository
class ProductRepository {
    fun findAll() = Product.all().toList()
    fun findById(id: Long): Product? = Product.findById(id)

}
