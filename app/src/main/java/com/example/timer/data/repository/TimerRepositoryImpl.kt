package com.example.timer.data.repository

import com.example.timer.data.storage.TimerStorage
import com.example.timer.data.storage.model.TimerModelStorage
import com.example.timer.domain.model.SaveTimerParam
import com.example.timer.domain.repository.TimerRepository

class TimerRepositoryImpl(private val timerStorage: TimerStorage): TimerRepository {
    override fun saveTimer(saveParams: SaveTimerParam) {
        return timerStorage.save(mapToStorage(saveParams))
    }

    override fun loadTimer(): SaveTimerParam {
        return mapToDomain(timerStorage.load())
    }

    private fun mapToStorage(saveParams: SaveTimerParam):TimerModelStorage{
        return TimerModelStorage(saveParams.milsecTimer,saveParams.secTimer,saveParams.minuteTimer)
    }
    private fun mapToDomain(timerModelStorage: TimerModelStorage): SaveTimerParam{
        return SaveTimerParam(
            timerModelStorage.timerMilsec,
            timerModelStorage.timerSec,
            timerModelStorage.timerMinute)
    }


}