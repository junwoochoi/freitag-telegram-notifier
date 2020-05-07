package com.junu.freitag

import com.junu.freitag.entity.ProductStock
import com.junu.freitag.table.ProductStocks
import org.jetbrains.exposed.dao.entityCache
import org.jetbrains.exposed.sql.Query
import org.jetbrains.exposed.sql.SizedIterable
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.reactive.TransactionContextManager

@SpringBootTest
class FreitagApplicationTests {

    @Test
    fun contextLoads() {
    }
}
