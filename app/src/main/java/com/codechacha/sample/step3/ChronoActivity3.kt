package com.codechacha.sample.step3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.codechacha.sample.R
import kotlinx.android.synthetic.main.activity_chrono_3.*

class ChronoActivity3 : AppCompatActivity() {
    companion object {
        const val TAG = "ChronoActivity3"
    }

    private var liveDataTimerViewModel: LiveDataTimerViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_chrono_3)
        liveDataTimerViewModel = ViewModelProviders.of(this).get(LiveDataTimerViewModel::class.java)

        subscribe()
    }

    private fun subscribe() {
        val elapsedTimeObserver = androidx.lifecycle.Observer<Long> { time ->
                timer_textview.text = time.toString()
                Log.d(TAG, "Updating timer")
        }

        //TODO: observe the ViewModel's elapsed time
        liveDataTimerViewModel?.elapsedTime?.observe(this, elapsedTimeObserver)
    }
}