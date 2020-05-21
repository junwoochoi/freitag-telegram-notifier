package com.junu.freitag.global.config

import com.junu.freitag.domain.notification.service.NotificationService
import com.junu.freitag.domain.stock.service.StockService
import mu.KotlinLogging
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.scheduling.annotation.SchedulingConfigurer
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler
import org.springframework.scheduling.config.ScheduledTaskRegistrar

@Configuration
@Profile("prod")
@EnableScheduling
class ScheduleConfig(
        private val stockService: StockService,
        private val notificationService: NotificationService
) : SchedulingConfigurer {
    private val log = KotlinLogging.logger {}

    companion object {
        const val POOL_SIZE = 10
    }

    override fun configureTasks(taskRegistrar: ScheduledTaskRegistrar) {

        val threadPoolTaskScheduler = ThreadPoolTaskScheduler()
        threadPoolTaskScheduler.poolSize = POOL_SIZE
        threadPoolTaskScheduler.setThreadNamePrefix("my-scheduled-task-pool")
        threadPoolTaskScheduler.initialize()

        taskRegistrar.setTaskScheduler(threadPoolTaskScheduler)
    }

    @Scheduled(fixedDelay = 15 * 60 * 1000, initialDelay = 3000)
    fun refreshStocks() {
        log.info { "--------------------------------------------------------"}
        log.info { "refresh Stocks Start! "}
        stockService.refreshStocks()
        log.info { "refrresh Complete! "}
        log.info { "--------------------------------------------------------"}
    }
}