package com.example.timer.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.ToggleButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.timer.R
import com.example.timer.view.CustomTimerView
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<TimerViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.text_timer)
        val loadView = findViewById<TextView>(R.id.load_timer)
        val saveButton = findViewById<Button>(R.id.saveTimer_button)
        val customTimerView = findViewById<CustomTimerView>(R.id.startStop_button)

        viewModel.allTimer.observe(this, Observer {
            loadView.text = it.toString()
        })

        viewModel.timerLiveData.observe(this, Observer{
            textView.text = it
        })
        //viewModel.loadTimerLiveData.observe(this, Observer {
            //loadView.text = it
        //})

        viewModel.stateButtonLiveData.observe(this, Observer {
             customTimerView.stateButton(it)
        })

        saveButton.setOnClickListener {
            viewModel.saveTimer(textView.text.toString())
        }
    }
}