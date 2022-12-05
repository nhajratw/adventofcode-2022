package com.chikli.adventofcode

import java.io.FileReader

fun main() {
    val inputData = FileReader("/tmp/day3.txt").readLines()
    val rucksacks = inputData.map { Rucksack(it) }
    println(rucksacks.sumOf { it.commonItemPriority() })
}

class Rucksack(private val items: String) {
    fun commonItem(): Char {
        val itemCount = items.length
        val firstCompartment = items.substring(0, itemCount / 2)
        val secondCompartment = items.substring(itemCount / 2, itemCount)
        val common = firstCompartment.toSet().intersect(secondCompartment.toSet())
        return common.first()
    }

    fun commonItemPriority(): Int {
        val item = commonItem()

        return if (item < 'a') item.code - 38
        else item.code - 96
    }

}
