package me.banes.chris.insetter

import android.os.Bundle

class ConsumedInsets : CommonInsetterActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)
    }

    override fun consumeInsets(): Boolean {
        return true
    }

}