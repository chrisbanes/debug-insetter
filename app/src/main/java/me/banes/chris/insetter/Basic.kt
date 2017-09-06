package me.banes.chris.insetter

import android.os.Bundle

class Basic : CommonInsetterActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)
    }

    override fun requestFullscreenFlags(): Boolean {
        return false
    }

}