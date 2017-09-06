package me.banes.chris.insetter

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onBasicClicked(view: View) {
        startActivity(Intent(this, Basic::class.java))
    }

    fun onConsumedInsetsClicked(view: View) {
        startActivity(Intent(this, ConsumedInsets::class.java))
    }

    fun onUnconsumedInsetsClicked(view: View) {
        startActivity(Intent(this, UnconsumedInsets::class.java))
    }
}
