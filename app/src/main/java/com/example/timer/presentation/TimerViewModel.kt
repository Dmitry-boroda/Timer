package com.example.timer.presentation
import android.util.Log
import androidx.lifecycle.*
import com.example.timer.data.repository.TimerRepositoryImpl
import com.example.timer.data.storage.room.Time
import com.example.timer.domain.model.SaveTimerParam
import com.example.timer.domain.model.TimerModel
import com.example.timer.domain.model.TimerParam
import com.example.timer.domain.repository.TimerRepository
import com.example.timer.domain.usecase.LapTimer
import com.example.timer.domain.usecase.SaveTimer
import kotlinx.coroutines.launch

class TimerViewModel(
    private val lapTimer: LapTimer,
    private val saveTimer: SaveTimer,
    private val timerModel: TimerModel,
    private val repository: TimerRepository
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

    val allTimer: LiveData<List<Time>> = repository.allTime.asLiveData()

    fun insert(time: Time) = viewModelScope.launch {
        repository.insert(time)
    }
    fun delAll() = viewModelScope.launch {
        repository.delAll()
    }

    fun startTimer(stateButton: Boolean){
        when (stateButton) {
            true -> timerModel.startTimer(textCallback)
            false -> timerModel.stopTimer()
        }
        stateButtonMutableLiveData.value = !stateButton
    }

    fun saveTimer(timer:String){
        insert(time= Time(timer))

        saveTimer.execute(SaveTimerParam(timer))
        val timerParam: TimerParam = lapTimer.execute()
        loadTimerMutableLiveData.value = timerParam.timer

    }
}

interface TextCallback{
    fun updateText(str: String)
}