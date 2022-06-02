package com.example.timer.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.timer.domain.usecase.LapTimer

class TimerViewModel(
    //private val lapTimer: LapTimer
    ): ViewModel() {

    private val milsecMutableLiveData = MutableLiveData<Int>()
    private val secondMutableLiveData = MutableLiveData<Int>()
    private val minuteMutableLiveData = MutableLiveData<Int>()

    val milsecLiveData: LiveData<Int> = milsecMutableLiveData
    val secondLiveData: LiveData<Int> = secondMutableLiveData
    val minuteLiveData: LiveData<Int> = minuteMutableLiveData

    init {
        Log.e("AAA","ViewModel Create")
    }

    override fun onCleared() {
        Log.e("AAA", "ViewModel Cleared")
        super.onCleared()
    }

}