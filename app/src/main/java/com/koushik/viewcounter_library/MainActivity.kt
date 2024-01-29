package com.koushik.viewcounter_library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCounter.getInstance().showViewCount(this,findViewById(android.R.id.content))
    }
}