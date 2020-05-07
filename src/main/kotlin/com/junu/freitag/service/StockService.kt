package com.junu.freitag.service

import com.junu.freitag.client.FreitagApiClient
import com.junu.freitag.entity.Product
import com.junu.freitag.entity.ProductStock
import com.junu.freitag.table.ProductStocks
import org.jetbrains.exposed.sql.*
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class StockService(private val freitagApiClient: FreitagApiClient) {

//    @EventListener(ApplicationReadyEvent::class)
//    @Transactional
//    fun test() {
//        val product = Product.new {
//            productName = "F343_01431 CASE FOR IPHONE® XS/X"
//            productId = "16863"
//        }
//    }

    @Transactional
    fun refreshStocks() {
        val allProducts = Product.all()

        for (product in allProducts) {
            retrieveStocks(product)
        }
    }

    private fun retrieveStocks(product: Product) {
        val stocks = freitagApiClient.findStocks(product.productId)
        val stockIds = stocks.products.map {
            it.product.productId
        }

        val soldoutStocks = ProductStock.find {
            ProductStocks.stockId notInList (stockIds) and
                    (ProductStocks.exists eq true)
        }

        for (soldoutStock in soldoutStocks) {
            soldoutStock.soldOut()
        }

        val exists = ProductStock.find { ProductStocks.exists eq true }.notForUpdate()
//        val exists = ProductStock.wrapRows(ProductStocks.select { ProductStocks.exists eq true }).toList()


        for (i in listOf(1,2,3,4,5,6)) {
            exists.forEach {
                println(it.stockId)
                println(it.javaClass)
            }
            println("----")
        }
//        stocks.products
//                .forEach { stock ->
//                    exists.forEach {
//                        println(it.stockId)
//                    }
//                    println("----")
//                }
//    }
//                .forEach {
//                    ProductStock.new {
//                        imageUrl = it.product.neoProductCoverPhoto.src
//                        color = it.product.neoProductColors.trim()
//                        stockId = it.product.productId
//                    }
//                }


    }
}
