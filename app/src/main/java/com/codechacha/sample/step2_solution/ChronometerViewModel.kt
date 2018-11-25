package com.codechacha.sample.step2_solution

import androidx.annotation.Nullable
import androidx.lifecycle.ViewModel


class ChronometerViewModel : ViewModel() {

    @Nullable
    @get:Nullable
    var startTime: Long? = null
        private set

    fun setStartTime(startTime: Long) {
        this.startTime = startTime
    }
}
