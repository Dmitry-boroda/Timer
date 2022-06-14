package com.example.timer.domain.model

import android.util.Log
import com.example.timer.presentation.TextCallback
import java.util.*

class TimerModel (){

    private var timer: Timer? = null
    private val timerTask
        get() = object : TimerTask(){
            override fun run() {
                count++
                callback?.updateText(toString(count))
            }
        }
    private var callback: TextCallback? =null
    private var count = -1
    fun startTimer(textCallback: TextCallback){
        callback= textCallback
        timer = Timer()
        timer?.scheduleAtFixedRate(timerTask,0,1)
    }
    fun stopTimer(){
        timer?.cancel()
        timer=null
        count=-1
    }
    private fun toString(time: Int): String{
        return "${String.format("%tM",time.toLong())}." +
                "${String.format("%tS",time.toLong())}." +
                String.format("%tL",time.toLong())
    }

}
