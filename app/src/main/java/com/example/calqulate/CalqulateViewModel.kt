package com.example.calqulate

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalqulateViewModel: ViewModel() {
    var state by mutableStateOf(CalqulateState())
        private set

    fun onAction(action: CalqulateAction) {
        when(action) {
            is CalqulateAction.Number -> enterNumber(action.number)
            is CalqulateAction.Decimal -> enterDecimal()
            is CalqulateAction.Clear -> state = CalqulateState()
            is CalqulateAction.Operation -> enterOperation(action.operation)
            is CalqulateAction.Calculate -> performCalculation()
            is CalqulateAction.Delete -> performDeletion()
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.number1.length < MAX_NUM_LENGTH) {
                state = state.copy(
                    number1 = state.number1 + number
                )
            }
        } else {
            if (state.number2.length < MAX_NUM_LENGTH) {
                state = state.copy(
                    number2 = state.number2 + number
                )
            }
        }
    }

    private companion object {
        const val MAX_NUM_LENGTH = 8
    }

    private fun performDeletion() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation = null
            )
            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1 != null && number2 != null) {
            val result = when (state.operation) {
                is CalqulateOperation.Add -> number1!! + number2!!
                is CalqulateOperation.Subtract -> number1!! - number2!!
                is CalqulateOperation.Multiply -> number1!! * number2!!
                is CalqulateOperation.Divide -> number1!! / number2!!
                null -> return
            }
            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            )
        }
    }

    private fun enterOperation(operation: CalqulateOperation) {
        if (state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
        if (state.number2.isNotBlank()) {
            performCalculation()
        }
    }

    private fun enterDecimal() {
        if(state.operation == null && !state.number1.contains(".")
            && state.number1.isNotBlank()
            ) {
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        }
        if (!state.number2.contains(".")
            && state.number2.isNotBlank()
        ) {
            state = state.copy(
                number2 = state.number2 + "."
            )
        }
    }
}
