package com.example.timer.domain.usecase

import java.util.*

class LapTimer {
    private var timer: Timer? = null
    private val timerTask
        get() = object : TimerTask(){
            override fun run() {
                count++
            }
        }
    private var count = -1
    fun startTimer(){
        timer = Timer()
        timer?.scheduleAtFixedRate(timerTask,0,1000)
    }
    fun stopTimer(){
        timer?.cancel()
        timer=null
        count=-1
    }
}