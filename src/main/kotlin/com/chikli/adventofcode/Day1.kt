package com.chikli.adventofcode

import java.io.FileReader

fun main() {
    val inputData = FileReader("/tmp/day1.txt").readLines()
    println(CalorieList(inputData).totalOfTopThree())
}

class CalorieList(calories: List<String>) {

    private val normalizedCalories = calories + ""

    fun theMostCalories(): Int {
        return allCalorieTotals().max()
    }

    fun totalOfTopThree(): Int {
        return allCalorieTotals().sortedDescending().take(3).sum()
    }

    private fun allCalorieTotals(): List<Int> {
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
        return calorieTotals
    }
}

