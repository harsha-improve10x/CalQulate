package com.example.calqulate

sealed class CalqulateAction {
    data class Number(val number: Int) : CalqulateAction()
    data object Clear : CalqulateAction()
    data object Delete : CalqulateAction()
    data object Decimal : CalqulateAction()
    data object Calculate : CalqulateAction()
    data class Operation(val operation: CalqulateOperation) : CalqulateAction()
}