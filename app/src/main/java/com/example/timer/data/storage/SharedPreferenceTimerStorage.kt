package com.example.timer.data.storage

import android.content.Context
import com.example.timer.data.storage.model.TimerModelStorage

class SharedPreferenceTimerStorage(context: Context): TimerStorage {

    private val sharedPreferences = context.getSharedPreferences("timer",Context.MODE_PRIVATE)

    override fun save(timerModelStorage: TimerModelStorage): Boolean {
        sharedPreferences.edit().putInt("Minute",timerModelStorage.timerMinute)
        return true
    }

    override fun load(): TimerModelStorage {
        return TimerModelStorage(
            sharedPreferences.getInt("Minute",0)
        )
    }
}