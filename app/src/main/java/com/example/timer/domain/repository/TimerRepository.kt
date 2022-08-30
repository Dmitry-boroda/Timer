package com.example.timer.domain.repository

import com.example.timer.data.storage.room.Time
import com.example.timer.domain.model.SaveTimerParam
import com.example.timer.domain.model.TimerParam
import kotlinx.coroutines.flow.Flow

interface TimerRepository {
    val allTime: Flow<List<Time>>

    fun saveTimer(saveParams: SaveTimerParam): Boolean
    fun loadTimer(): TimerParam
    suspend fun insert(time: Time)
    suspend fun delAll()
}