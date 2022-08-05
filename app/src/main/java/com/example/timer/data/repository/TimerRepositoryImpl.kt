package com.example.timer.data.repository

import androidx.annotation.WorkerThread
import com.example.timer.data.storage.TimerStorage
import com.example.timer.data.storage.model.TimerModelStorage
import com.example.timer.data.storage.room.Time
import com.example.timer.data.storage.room.TimeDao
import com.example.timer.domain.model.SaveTimerParam
import com.example.timer.domain.model.TimerParam
import com.example.timer.domain.repository.TimerRepository
import kotlinx.coroutines.flow.Flow

class TimerRepositoryImpl(
    private val timerStorage: TimerStorage,
    //new
    private val timeDao: TimeDao
): TimerRepository {

    val allTime: Flow<List<Time>> = timeDao.getListTime()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    override suspend fun insert(time: Time){
        timeDao.insert(time)
    }

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