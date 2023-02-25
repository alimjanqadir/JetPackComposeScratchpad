package com.example.drawpad.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import ui.theme.DrawPadTheme

class ChartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, parent: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                DrawPadTheme {
                    Column {
                        Text("Hello")
                    }
                }
            }
        }
    }

    companion object {
        fun newInstance(): Fragment {
            return ChartFragment()
        }
    }

}