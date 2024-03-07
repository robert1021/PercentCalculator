package com.sparlinginteractive.percentcalculator
import kotlin.math.abs

class CalculatePercent {


    fun calculatePercentOf(percent: Double, amount: Double): Double {
        return (percent / 100) * amount
    }

    fun calculatePercentDifference(num1: Double, num2: Double): Double {
        return (abs(num1 - num2) / ((num1 + num2) / 2)) * 100
    }

    fun calculatePercentIncrease(originalValue: Double, newValue: Double): Double {
        return ((newValue - originalValue) / originalValue) * 100
    }

    fun calculatePercentDecrease(originalValue: Double, newValue: Double): Double {
        return ((originalValue - newValue) / originalValue) * 100
    }

}