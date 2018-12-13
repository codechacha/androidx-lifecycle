package com.codechacha.sample.step2_solution

import androidx.annotation.Nullable
import androidx.lifecycle.ViewModel


class ChronometerViewModel : ViewModel() {

    var startTime: Long? = 0
        private set

    fun setStartTime(startTime: Long) {
        this.startTime = startTime
    }
}
