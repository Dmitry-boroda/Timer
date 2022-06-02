package com.example.timer.domain.repository

import com.example.timer.domain.model.SaveTimerParam

interface TimerRepository {
    fun saveTimer(saveParams: SaveTimerParam)
    fun loadTimer(): SaveTimerParam
}