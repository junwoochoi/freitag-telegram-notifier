package com.junu.freitag.user.service

import com.junu.freitag.user.entity.User
import com.junu.freitag.user.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService(private val userRepository: UserRepository) {

    fun findByTelegramId(id: Int): User? = userRepository.findByTelegramId(id)

    fun renewUserData(from: org.telegram.telegrambots.meta.api.objects.User) {
        val user = (userRepository.findByTelegramId(from.id)
                ?: userRepository.create(telegramId = from.id, username = from.userName))


        user.renewLastSentAt()
        user.updateUsername(from.userName)
    }

}