package com.example.calqulate

sealed class CalqulateOperation(val symbol: String) {
    data object Add : CalqulateOperation("+")
    data object Subtract : CalqulateOperation("-")
    data object Multiply : CalqulateOperation("x")
    data object Divide : CalqulateOperation("/")
}