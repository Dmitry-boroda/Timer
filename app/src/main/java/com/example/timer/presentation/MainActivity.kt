package com.example.timer.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.timer.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: TimerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, TimerViewModelFactory(this))
            .get(TimerViewModel::class.java)

        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.text_timer)
        val startButton = findViewById<Button>(R.id.startStop_button)

        viewModel.milsecLiveData.observe(this, Observer {
            textView.text = it.toString()
        })

        startButton.setOnClickListener {

        }
    }
}