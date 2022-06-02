package com.example.timer.data.storage

import com.example.timer.data.storage.model.TimerModelStorage

interface TimerStorage {
    fun save(timerModelStorage: TimerModelStorage)
    fun load(): TimerModelStorage
}