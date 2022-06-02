package com.example.timer.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.timer.data.repository.TimerRepositoryImpl
import com.example.timer.data.storage.SharedPreferenceTimerStorage

class TimerViewModelFactory(context: Context): ViewModelProvider.NewInstanceFactory() {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE){
        TimerRepositoryImpl(SharedPreferenceTimerStorage(context))
    }



    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return TimerViewModel() as T

    }
}