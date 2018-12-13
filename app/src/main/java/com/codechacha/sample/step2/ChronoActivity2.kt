package com.codechacha.sample.step2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codechacha.sample.R
import kotlinx.android.synthetic.main.activity_chrono_2.*

class ChronoActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chrono_2)

        chronometer.start()
    }
}
