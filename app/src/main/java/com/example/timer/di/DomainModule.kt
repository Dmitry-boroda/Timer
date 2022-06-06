package com.example.timer.di

import com.example.timer.domain.model.TimerModel
import com.example.timer.domain.usecase.CleanTimers
import com.example.timer.domain.usecase.LapTimer
import com.example.timer.domain.usecase.SaveTimer
import org.koin.dsl.module

val domainModule = module {
    factory {
        LapTimer(timerRepository = get())
    }
    factory {
        SaveTimer(timerRepository = get())
    }
    factory {
        TimerModel()
    }
}