package ru.cybereagleowl.main_screen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import ru.cybereagleowl.ui_core.applyWindowInsetsCompat

class MainScreenFragment : Fragment() {

    private var backPressed: Long = 0

    private lateinit var viewModel: MainScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This callback will only be called when AuthFragment is at least Started.
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            // Handle the back button event
            customOnBackPressedCallbackHandle()
        }
        //Enable callback
        callback.isEnabled = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_screen_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainScreenViewModel::class.java)
        // TODO: Use the ViewModel
    }
    
    companion object {
        fun newInstance() = MainScreenFragment()
    }

    private fun customOnBackPressedCallbackHandle() {
        requireActivity().let {
            if (backPressed + 2000 > System.currentTimeMillis()) {
                it.finish()
            } else {
                Toast.makeText(it, R.string.doble_back_notify, Toast.LENGTH_SHORT).show()
            }
        }
        backPressed = System.currentTimeMillis()
    }
}