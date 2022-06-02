package com.example.timer.data.storage

import android.content.Context
import com.example.timer.data.storage.model.TimerModelStorage

class SharedPreferenceTimerStorage(context: Context): TimerStorage {

    private val sharedPreferences = context.getSharedPreferences("timer",Context.MODE_PRIVATE)

    override fun save(timerModelStorage: TimerModelStorage) {
        sharedPreferences.edit().putInt("Milsec",timerModelStorage.timerMilsec)
        sharedPreferences.edit().putInt("Second",timerModelStorage.timerSec)
        sharedPreferences.edit().putInt("Minute",timerModelStorage.timerMinute)
    }

    override fun load(): TimerModelStorage {
        return TimerModelStorage(
            sharedPreferences.getInt("Milsec",0),
            sharedPreferences.getInt("Second",0),
            sharedPreferences.getInt("Minute",0)
        )
    }
}