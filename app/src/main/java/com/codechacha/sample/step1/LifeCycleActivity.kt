package com.codechacha.sample.step1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codechacha.sample.R

class LifeCycleActivity : AppCompatActivity() {

    private var observer = MyObserver(lifecycle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)

        lifecycle.addObserver(observer)
    }

}