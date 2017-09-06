package me.banes.chris.insetter

import android.app.Activity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.include_content.*

abstract class CommonInsetterActivity : Activity() {

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        debug_title.text = localClassName

        root.setOnApplyWindowInsetsListener { _, windowInsets ->
            debug_insets.text = "Insets [ $windowInsets ]"

            if (consumeInsets()) windowInsets.consumeSystemWindowInsets() else windowInsets
        }
        if (requestFullscreenFlags()) {
            root.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        }
        root.requestApplyInsets()

        window.decorView.addOnLayoutChangeListener { view, _, _, _, _, _, _, _, _ ->
            val array = IntArray(2)
            view.getLocationOnScreen(array)

            debug_android_decor_view.text = "[ ${array[0]}, ${array[1]}, ${array[0] + view.width}, ${array[1] + view.height} ]"
        }

        root.addOnLayoutChangeListener { view, _, _, _, _, _, _, _, _ ->
            val array = IntArray(2)
            view.getLocationOnScreen(array)

            debug_content_root.text = "[ ${array[0]}, ${array[1]}, ${array[0] + view.width}, ${array[1] + view.height} ]"
        }

        findViewById<View>(android.R.id.content).addOnLayoutChangeListener { view, _, _, _, _, _, _, _, _ ->
            val array = IntArray(2)
            view.getLocationOnScreen(array)

            debug_android_content_root.text = "[ ${array[0]}, ${array[1]}, ${array[0] + view.width}, ${array[1] + view.height} ]"
        }

        debug_density.text = resources.displayMetrics.density.toString()
    }

    open fun consumeInsets() : Boolean {
        return false
    }

    open fun requestFullscreenFlags() : Boolean {
        return true
    }

}