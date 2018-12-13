package com.codechacha.sample.step3

import android.os.SystemClock
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class LiveDataTimerViewModel : ViewModel() {

    companion object {
        private val ONE_SECOND = 1000.toLong()
    }

    private val initialTime: Long = SystemClock.elapsedRealtime()
    var elapsedTime = MutableLiveData<Long>()
        private set

    init {
        val timer = Timer()
        // Update the elapsed time every second.
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                val newValue = (SystemClock.elapsedRealtime() - initialTime) / 1000

                //TODO post the new value with LiveData.postValue()
                elapsedTime.postValue(newValue)
            }
        }, ONE_SECOND, ONE_SECOND)
    }
}
