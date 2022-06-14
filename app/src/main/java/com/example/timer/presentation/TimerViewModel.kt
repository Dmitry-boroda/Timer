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

    private var textObservable: TextObservable?=null

    private val textCallback = object : TextCallback{
        override fun updateText(str: String){
            textObservable?.postValue(str)
        }
    }
    private val minuteMutableLiveData = MutableLiveData<String>()
    val minuteLiveData: LiveData<String> = minuteMutableLiveData

    fun init(textObservable: TextObservable) {
        this.textObservable = textObservable
    }

    override fun onCleared() {
        Log.e("AAA", "ViewModel Cleared")
        super.onCleared()
    }

    fun startTimer(){
        timerModel.startTimer(textCallback)
    }
}
class TextObservable{
    private lateinit var callback: TextCallback
    fun observable(callback: TextCallback){
        this.callback = callback
    }
    fun postValue(text: String){
        callback.updateText(text)
    }
}
interface TextCallback{
    fun updateText(str: String)
}