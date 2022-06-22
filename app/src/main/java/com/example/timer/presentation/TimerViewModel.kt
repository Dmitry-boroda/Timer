package com.example.timer.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.timer.domain.model.SaveTimerParam
import com.example.timer.domain.model.TimerModel
import com.example.timer.domain.model.TimerParam
import com.example.timer.domain.usecase.LapTimer
import com.example.timer.domain.usecase.SaveTimer

class TimerViewModel(
    private val lapTimer: LapTimer,
    private val saveTimer: SaveTimer,
    private val timerModel: TimerModel
    ): ViewModel() {

    private val textCallback = object : TextCallback{
        override fun updateText(str: String){
            timerMutableLiveData.postValue(str)
        }
    }

    private val timerMutableLiveData = MutableLiveData<String>()
    val timerLiveData: LiveData<String> = timerMutableLiveData

    private val loadTimerMutableLiveData = MutableLiveData<String>()
    val loadTimerLiveData: LiveData<String> = loadTimerMutableLiveData

    override fun onCleared() {
        Log.e("AAA", "ViewModel Cleared")
        super.onCleared()
    }

    fun startTimer(){
        timerModel.startTimer(textCallback)
        Log.e("AAA", "start")
    }
    fun saveTimer(timer:String){

        val param = SaveTimerParam(timer)
        val result: Boolean = saveTimer.execute(param)
        loadTimerMutableLiveData.value = "$result"
        val timerParam: TimerParam = lapTimer.execute()
        loadTimerMutableLiveData.value = timerParam.timer

    }
}
interface TextCallback{
    fun updateText(str: String)
}