package com.example.calqulate

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalqulateViewModel: ViewModel() {
    var state by mutableStateOf(CalqulateState())
        private set
}
