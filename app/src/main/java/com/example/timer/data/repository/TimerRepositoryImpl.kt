package com.example.timer.data.repository

import com.example.timer.data.storage.TimerStorage
import com.example.timer.data.storage.model.TimerModelStorage
import com.example.timer.domain.model.SaveTimerParam
import com.example.timer.domain.model.TimerParam
import com.example.timer.domain.repository.TimerRepository

class TimerRepositoryImpl(private val timerStorage: TimerStorage): TimerRepository {
    override fun saveTimer(saveParams: SaveTimerParam):Boolean {
        return timerStorage.save(mapToStorage(saveParams))
    }

    override fun loadTimer(): TimerParam {
        return mapToDomain(timerStorage.load())
    }

    private fun mapToStorage(saveParams: SaveTimerParam):TimerModelStorage{
        return TimerModelStorage(saveParams.timerParam)
    }
    private fun mapToDomain(timerModelStorage: TimerModelStorage): TimerParam{
        return TimerParam(timerModelStorage.timerStorage)
    }


}