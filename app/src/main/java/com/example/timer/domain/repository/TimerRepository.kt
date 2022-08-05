package com.example.timer.domain.repository

import com.example.timer.data.storage.room.Time
import com.example.timer.domain.model.SaveTimerParam
import com.example.timer.domain.model.TimerParam

interface TimerRepository {
    fun saveTimer(saveParams: SaveTimerParam): Boolean
    fun loadTimer(): TimerParam
    suspend fun insert(time: Time)
}