package com.example.timer.presentation

import android.util.Log
import androidx.lifecycle.*
import com.example.timer.data.repository.TimerRepositoryImpl
import com.example.timer.data.storage.room.Time
import com.example.timer.domain.model.SaveTimerParam
import com.example.timer.domain.model.TimerModel
import com.example.timer.domain.model.TimerParam
import com.example.timer.domain.usecase.LapTimer
import com.example.timer.domain.usecase.SaveTimer
import kotlinx.coroutines.launch


class TimerViewModel(
    private val lapTimer: LapTimer,
    private val saveTimer: SaveTimer,
    private val timerModel: TimerModel,
    private val repositoryImpl: TimerRepositoryImpl
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

    private val stateButtonMutableLiveData = MutableLiveData<Boolean>()
    val stateButtonLiveData: LiveData<Boolean> = stateButtonMutableLiveData


    val allTimer: LiveData<List<Time>> = repositoryImpl.allTime.asLiveData()

    fun insert(time: Time) = viewModelScope.launch {
        repositoryImpl.insert(time)
    }

    fun startTimer(stateButton: Boolean){
        if (stateButton) {
            timerModel.startTimer(textCallback)
            stateButtonMutableLiveData.value = !stateButton
        }else{
            timerModel.stopTimer()
            stateButtonMutableLiveData.value = !stateButton
        }
        Log.e("AAA", "start")
    }
    fun saveTimer(timer:String){

        val time = Time(timer)
        insert(time)

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