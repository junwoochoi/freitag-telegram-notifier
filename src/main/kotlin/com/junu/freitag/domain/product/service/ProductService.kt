package com.junu.freitag.domain.product.service

import com.junu.freitag.domain.product.repository.ProductRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ProductService(private val productRepository: ProductRepository) {
    fun findAll() = productRepository.findAll()
    fun findById(id: Long) = productRepository.findById(id)



}
