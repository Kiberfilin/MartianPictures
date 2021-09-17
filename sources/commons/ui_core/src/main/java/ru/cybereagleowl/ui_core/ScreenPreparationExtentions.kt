package ru.cybereagleowl.ui_core

import android.app.Activity
import android.view.View
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import dev.chrisbanes.insetter.applyInsetter

/**
 * Prepares [Activity] for edge-to-edge screen by preventing the
 * decor view from fitting root-level content views for [WindowInsetsCompat].
 *
 * The framework will not fit the content view to the insets and will
 * just pass through the [WindowInsetsCompat] to the content view.
 *
 * @author Kiberfilin
 * */
fun Activity.edgeToEdgeScreenPreparation() {
    WindowCompat.setDecorFitsSystemWindows(window, false)
}

/**
 *Applies [WindowInsetsCompat] to the root [View] of the [Fragment]'s layout.
 *
 * The navigation bar and status bar insets are applying as padding.
 *
 * Be careful! It should be used after [Fragment.onCreateView] method.
 *
 * @author Kiberfilin
 * */
fun Fragment.applyWindowInsetsCompat() {
    this.requireView().applyInsetter {
        type(navigationBars = true, statusBars = true) {
            padding()
        }
    }
}

/**
 *Applies [WindowInsetsCompat] to the [View].
 *
 * The navigation bar and status bar insets are applying as padding.
 *
 * Be careful! It should be used after [Fragment.onCreateView] method.
 *
 * @author Kiberfilin
 * */
fun View.applyWindowInsetsCompat(navigationBars: Boolean = true, statusBars: Boolean = true) {
    this.applyInsetter {
        type(navigationBars = navigationBars, statusBars = statusBars) {
            padding()
        }
    }
}