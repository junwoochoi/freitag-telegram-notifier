package com.junu.freitag.global.aop

import com.junu.freitag.domain.user.service.UserService
import mu.KotlinLogging
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.Update

@Aspect
@Component
class BasicUserInfoAspect(private val userService: UserService) {

    private val log = KotlinLogging.logger { }

    @Before("@annotation(UserBasicInfo)")
    fun saveBasicUserInfo(joinPoint: JoinPoint) {
        val filterIsInstance = joinPoint.args.filterIsInstance<Update>()
        if (filterIsInstance.isEmpty()) {
            throw IllegalArgumentException("Update is NULL")
        }

        val update = filterIsInstance[0]
        val receivedMessage: Message = update.message

        log.info { "received Message : $receivedMessage" }

        userService.renewUserData(from = receivedMessage.from)

    }
}