package com.example.timer.di

import com.example.timer.data.repository.TimerRepositoryImpl
import com.example.timer.data.storage.SharedPreferenceTimerStorage
import com.example.timer.data.storage.TimerStorage
import com.example.timer.domain.repository.TimerRepository
import com.example.timer.presentation.TimerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {

    single<TimerStorage> {
        SharedPreferenceTimerStorage(context = get())
    }
    single<TimerRepository> {
        TimerRepositoryImpl(timerStorage = get())
    }
}