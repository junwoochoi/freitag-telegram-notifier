package com.junu.freitag.stock.service

import com.junu.freitag.global.client.FreitagApiClient
import com.junu.freitag.product.entity.Product
import com.junu.freitag.stock.repository.StockRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional


@Component
@Transactional
class StockService(
        private val freitagApiClient: FreitagApiClient,
        private val stockRepository: StockRepository
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

        stocks.products.filter { wrapper ->
            !exists.any { it.stockId == wrapper.product.productId }
        }.map {
            stockRepository.create(
                    stockId = it.product.productId,
                    color = it.product.neoProductColors.trim(),
                    imageUrl = it.product.neoProductCoverPhoto.src,
                    product = product)
        }
    }
}