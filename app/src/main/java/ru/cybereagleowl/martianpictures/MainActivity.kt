package ru.cybereagleowl.martianpictures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.cybereagleowl.ui_core.edgeToEdgeScreenPreparation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_MartianPicturesMainTheme) // Removing splash screen
        setContentView(R.layout.activity_main)

        edgeToEdgeScreenPreparation()
    }
}