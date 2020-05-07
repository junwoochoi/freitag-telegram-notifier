package com.junu.freitag.service

import com.junu.freitag.client.FreitagApiClient
import com.junu.freitag.dao.StockDao
import com.junu.freitag.entity.Product
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class StockService(
        private val freitagApiClient: FreitagApiClient,
        private val stockDao: StockDao
) {

    @Transactional
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
        stockDao.findSoldOutStocks(searchedIds)
                .forEach { it.soldOut() }

        val exists = stockDao.findMarkedExists()

        stocks.products.filter { wrapper ->
            !exists.any { it.stockId == wrapper.product.productId }
        }.map {
            stockDao.create(
                    stockId = it.product.productId,
                    color = it.product.neoProductColors.trim(),
                    imageUrl = it.product.neoProductCoverPhoto.src,
                    product = product)
        }


    }
}
