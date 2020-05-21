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
        val product = productService.findByProductId(productId.toString()) ?: throw IllegalArgumentException("존재하지 않는 제품입니다.")
        notificationRepository.create(user,product)
    }

    fun notifyProduct(productId: String, imageUrl: String) {
        //TODO 새로운 프로덕트에 알림 설정된 사람들에게 알림전송
    }

}