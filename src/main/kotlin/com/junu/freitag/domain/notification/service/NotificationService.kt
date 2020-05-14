package com.junu.freitag.domain.notification.service

import com.junu.freitag.domain.notification.repository.NotificationRepository
import com.junu.freitag.domain.product.service.ProductService
import com.junu.freitag.domain.user.entity.User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class NotificationService(private val notificationRepository: NotificationRepository,
                          private val productService: ProductService) {

    @Transactional
    fun create(productId: Long, user: User) {
        val product = productService.findById(productId) ?: throw IllegalArgumentException("존재하지 않는 제품입니다.")
        notificationRepository.create(user,product)
    }

}