package com.junu.freitag.exception

class UserNotExistException(id: Int) : FreitagException(message = "[ telegram_id : $id ] 의 유저가 존재하지 않습니다.")
