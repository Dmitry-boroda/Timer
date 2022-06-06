package com.example.timer.data.storage

import com.example.timer.data.storage.model.TimerModelStorage

interface TimerStorage {
    fun save(timerModelStorage: TimerModelStorage):Boolean
    fun load(): TimerModelStorage
}