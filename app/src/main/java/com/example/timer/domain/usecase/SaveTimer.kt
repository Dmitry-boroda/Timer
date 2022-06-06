package com.example.timer.domain.usecase

import com.example.timer.domain.model.SaveTimerParam
import com.example.timer.domain.repository.TimerRepository

class SaveTimer(private val timerRepository: TimerRepository){
    fun execute(param: SaveTimerParam): Boolean{
        return timerRepository.saveTimer(param)
    }
}