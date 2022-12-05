package com.chikli.adventofcode

import java.io.FileReader

@Suppress("MagicNumber")
fun main() {
    val inputData = FileReader("/tmp/day3.txt").readLines()
    val rucksacks = inputData.map { Rucksack(it) }
    var total = 0
    for (i in rucksacks.indices step 3) {
        val item = Rucksack.commonItem(rucksacks[i], rucksacks[i + 1], rucksacks[i + 2])
        total += Rucksack.commonItemPriority(item)
    }
    println(total)
}

@Suppress("MagicNumber")
class Rucksack(val items: String) {

    companion object {

        fun commonItem(first: Rucksack, second: Rucksack, third: Rucksack): Char {
            return first.items.toSet().intersect(second.items.toSet()).intersect(third.items.toSet()).first()
        }

        fun commonItemPriority(item: Char): Int {
            return if (item < 'a') item.code - 38
            else item.code - 96
        }
    }
}
