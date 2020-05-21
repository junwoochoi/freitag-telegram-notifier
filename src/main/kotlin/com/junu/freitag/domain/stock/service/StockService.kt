package com.junu.freitag.domain.stock.service

import com.junu.freitag.domain.notification.service.NotificationService
import com.junu.freitag.global.client.FreitagApiClient
import com.junu.freitag.domain.product.entity.Product
import com.junu.freitag.domain.stock.repository.StockRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional


@Component
@Transactional
class StockService(
        private val freitagApiClient: FreitagApiClient,
        private val stockRepository: StockRepository,
        private val notificationService: NotificationService
) {

    fun refreshStocks() {
        val allProducts = Product.all().toList()

        for (product in allProducts) {
            retrieveStocks(product)
        }
    }

    private fun retrieveStocks(product: Product) {
        val stocks = freitagApiClient.findStocks(product.productId)
        val searchedIds = stocks.products.map {
            it.product.productId
        }
        stockRepository.findSoldOutStocks(searchedIds)
                .forEach { it.soldOut() }

        val exists = stockRepository.findMarkedExists()

        stocks.products.asSequence()
                .filter { wrapper ->
                    !exists.any { it.stockId == wrapper.product.productId }
                }.map {
                    stockRepository.create(
                            stockId = it.product.productId,
                            color = it.product.neoProductColors.trim(),
                            imageUrl = it.product.neoProductCoverPhoto.src,
                            product = product)
                }.forEach { notificationService.notifyProduct(it.product.productId, it.imageUrl) }
    }
}
