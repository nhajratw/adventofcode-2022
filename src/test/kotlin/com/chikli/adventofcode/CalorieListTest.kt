package com.chikli.adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalorieListTest {

    @Test
    fun `no elves`() {
        val calorieList = CalorieList(emptyList())
        assertThat(calorieList.theMostCalories()).isEqualTo(0)
    }

    @Test
    fun `one elf`() {
        val calorieList = CalorieList(listOf("1000"))
        assertThat(calorieList.theMostCalories()).isEqualTo(1000)
    }

    @Test
    fun `two elves with multiple calories`() {
        val calorieList = CalorieList(listOf("1000", "2000", "", "3000", "4000"))
        assertThat(calorieList.theMostCalories()).isEqualTo(7000)
    }

    @Test
    fun `first elf has most calories`() {
        val calorieList = CalorieList(listOf("3000", "", "1000"))
        assertThat(calorieList.theMostCalories()).isEqualTo(3000)
    }
}
