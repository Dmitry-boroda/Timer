package com.example.timer.view

import android.content.Context
import android.util.AttributeSet
import android.view.ContextThemeWrapper
import androidx.lifecycle.*
import androidx.savedstate.findViewTreeSavedStateRegistryOwner
import com.example.timer.R
import com.example.timer.presentation.TimerViewModel
import com.google.android.material.button.MaterialButton

private enum class ButtonState(val label: Int){
    START(R.string.Start),
    STOP(R.string.Stop)
}

class CustomTimerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialButton(
    ContextThemeWrapper(context,R.style.ButtonStyle),
    attrs,
    defStyleAttr) {
    private var buttonState: Boolean = true
    private val viewModel by lazy {
        ViewModelProvider(findViewTreeViewModelStoreOwner()!!).get<TimerViewModel>()
    }
    init {
        isClickable = true
        setTextButton(buttonState)
    }
    fun stateButton(state: Boolean){
        buttonState = state
        setTextButton(buttonState)
    }
    override fun performClick(): Boolean {
        if(super.performClick()) return true
        viewModel.startTimer(buttonState)
        invalidate()
        return true
    }
    private fun setTextButton(state: Boolean){
        if (state){
            this.text = context.getText(R.string.Start)
        }else this.text = context.getText(R.string.Stop)
    }
}


