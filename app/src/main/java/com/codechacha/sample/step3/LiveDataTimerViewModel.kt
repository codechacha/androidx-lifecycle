package com.codechacha.sample.step3

import android.os.SystemClock
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class LiveDataTimerViewModel : ViewModel() {

    companion object {
        const val TAG = "LiveDataTimerViewModel"
    }

    private val initialTime: Long = SystemClock.elapsedRealtime()
    private val elapsedTime = MyTimerLiveData()

    fun getElapsedTime() = elapsedTime
}
