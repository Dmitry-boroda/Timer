package com.example.timer.di

import android.app.Application
import androidx.room.Room
import com.example.timer.data.repository.TimerRepositoryImpl
import com.example.timer.data.storage.SharedPreferenceTimerStorage
import com.example.timer.data.storage.TimerStorage
import com.example.timer.data.storage.room.TimeDao
import com.example.timer.data.storage.room.TimerDatabase
import com.example.timer.domain.repository.TimerRepository
import org.koin.android.ext.koin.androidApplication

import org.koin.dsl.module

val dataModule = module {

    fun provideDatabase(application: Application): TimerDatabase{
        return Room.databaseBuilder(application, TimerDatabase::class.java, "timer_table")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideTimeDao(database: TimerDatabase):TimeDao{
        return database.timeDao()
    }

    single { provideDatabase(androidApplication()) }
    single { provideTimeDao(get()) }

    single<TimerStorage> {
        SharedPreferenceTimerStorage(context = get())
    }
    single<TimerRepository> {
        TimerRepositoryImpl(timerStorage = get(), timeDao = get())
    }

    factory {
        TimerRepositoryImpl(timerStorage = get(), timeDao = get())
    }

}