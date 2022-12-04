package com.chikli.adventofcode

import java.io.FileReader

fun main() {
    val inputData = FileReader("/tmp/day1.txt").readLines() + "\n"
    println(CalorieList(inputData).theMostCalories())
}

class CalorieList(calories: List<String>) {

    private val normalizedCalories = calories + ""

    fun theMostCalories(): Int {
        if (normalizedCalories == listOf("")) return 0

        val calorieTotals = mutableListOf<Int>()
        var currentTotal = 0
        normalizedCalories.forEach {
            if (it.isBlank()) {
                calorieTotals += currentTotal
                currentTotal = 0
            } else {
                currentTotal += it.toInt()
            }
        }

        return calorieTotals.max()
    }
}

