package com.example.calqulate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calqulate.ui.theme.CalQulateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalQulateTheme {
               val viewModel = viewModel<CalqulateViewModel>()
                val state = viewModel.state
                val buttonSpacing = 8.dp
            }
        }
    }
}