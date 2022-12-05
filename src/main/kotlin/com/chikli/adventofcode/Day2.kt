package com.chikli.adventofcode

import com.chikli.adventofcode.Outcome.DRAW
import com.chikli.adventofcode.Outcome.LOSE
import com.chikli.adventofcode.Outcome.WIN
import java.io.FileReader

fun main() {
    val inputData = FileReader("/tmp/day2.txt").readLines()
    val strategy = RpsStrategy(inputData.map {
        val symbols = it.split(' ')
        RpsStrategyEntry(Rps.from(symbols[0]), Outcome.from(symbols[1]))
    })

    println(strategy.totalScore())
}

class RpsStrategy(private val entries: List<RpsStrategyEntry>) {
    fun totalScore() = entries.sumOf { it.score() }
}

data class RpsStrategyEntry(val opponent: Rps, val outcome: Outcome) {

    fun score(): Int {
        val you = when (outcome) {
            WIN -> opponent.losesTo()
            LOSE -> opponent.beats()
            DRAW -> opponent
        }

        return you.score + outcome.score
    }
}

data class Rps(val score: Int) {
    fun losesTo() = when (this) {
        rock -> paper
        paper -> scissors
        scissors -> rock
        else -> throw IllegalArgumentException("invalid case")
    }

    fun beats() = when (this) {
        rock -> scissors
        paper -> rock
        scissors -> paper
        else -> throw IllegalArgumentException("invalid case")
    }

    companion object {
        val rock = Rps(1)
        val paper = Rps(2)
        val scissors = Rps(3)

        fun from(symbol: String): Rps {
            return when (symbol) {
                "A" -> rock
                "B" -> paper
                "C" -> scissors
                else -> throw UnknownStrategy(symbol)
            }
        }
    }
}

@Suppress("MagicNumber")
enum class Outcome(val score: Int) {
    WIN(6),
    LOSE(0),
    DRAW(3);

    companion object {
        fun from(symbol: String): Outcome {
            return when (symbol) {
                "X" -> LOSE
                "Y" -> DRAW
                "Z" -> WIN
                else -> throw UnknownStrategy(symbol)
            }
        }
    }
}

class UnknownStrategy(symbol: String) : RuntimeException("Can't translate symbol [$symbol]")

