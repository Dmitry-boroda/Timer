package com.example.timer.domain.usecase

import com.example.timer.domain.model.SaveTimerParam
import com.example.timer.domain.model.TimerParam
import com.example.timer.domain.repository.TimerRepository
import java.util.*

class LapTimer(val timerRepository: TimerRepository) {

    fun execute(): TimerParam {
        return timerRepository.loadTimer()
    }
}