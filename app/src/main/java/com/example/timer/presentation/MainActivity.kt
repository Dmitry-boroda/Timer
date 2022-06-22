package com.example.timer.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.timer.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<TimerViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.text_timer)
        val startButton = findViewById<Button>(R.id.startStop_button)

        viewModel.minuteLiveData.observe(this, Observer{
            textView.text = it
        })

        startButton.setOnClickListener {
            viewModel.startTimer()
        }

    }
}