package me.banes.chris.insetter

import android.os.Bundle

class UnconsumedInsets : CommonInsetterActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)
    }

}