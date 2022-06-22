package com.example.timer.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.timer.domain.model.TimerModel

class TimerViewModel(
    //private val lapTimer: LapTimer,
    //private val saveTimer: SaveTimer,
    private val timerModel: TimerModel
    ): ViewModel() {

    private val textCallback = object : TextCallback{
        override fun updateText(str: String){
            minuteMutableLiveData.postValue(str)
        }
    }

    private val minuteMutableLiveData = MutableLiveData<String>()
    val minuteLiveData: LiveData<String> = minuteMutableLiveData

    override fun onCleared() {
        Log.e("AAA", "ViewModel Cleared")
        super.onCleared()
    }

    fun startTimer(){
        timerModel.startTimer(textCallback)
        Log.e("AAA", "start")
    }
}
interface TextCallback{
    fun updateText(str: String)
}