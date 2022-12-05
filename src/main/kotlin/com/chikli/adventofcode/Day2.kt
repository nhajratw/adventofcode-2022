package com.chikli.adventofcode

import java.io.FileReader

fun main() {
    val inputData = FileReader("/tmp/day2.txt").readLines()
    val strategy = RpsStrategy(inputData.map {
        val symbols = it.split(' ')
        RpsStrategyEntry(Rps.from(symbols[0]), Rps.from(symbols[1]))
    })

    println(strategy.totalScore())
}

class RpsStrategy(private val entries: List<RpsStrategyEntry>) {

    fun totalScore() = entries.sumOf { it.score() }
}

data class RpsStrategyEntry(val opponent: Rps, val you: Rps) {

    fun score(): Int {
        val winnerScore = when {
            you > opponent -> 6
            opponent > you -> 0
            else -> 3
        }

        return winnerScore + you.score
    }
}

data class Rps(val score: Int) {
    operator fun compareTo(other: Rps): Int {
        return when {
            this == other -> 0
            this == rock && other == scissors ||
                    this == scissors && other == paper ||
                    this == paper && other == rock -> 1

            else -> -1
        }
    }

    companion object {
        val rock = Rps(1)
        val paper = Rps(2)
        val scissors = Rps(3)

        fun from(symbol: String): Rps {
            return when (symbol) {
                "A", "X" -> rock
                "B", "Y" -> paper
                "C", "Z" -> scissors
                else -> throw UnknownStrategy(symbol)
            }
        }
    }
}

class UnknownStrategy(symbol: String) : RuntimeException("Can't translate symbol [$symbol]")

