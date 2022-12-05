package com.chikli.adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day3Test {

    @Test
    fun `example items`() {
        assertThat(Rucksack("vJrwpWtwJgWrhcsFMMfFFhFp").commonItem()).isEqualTo('p')
        assertThat(Rucksack("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn").commonItem()).isEqualTo('v')
        assertThat(Rucksack("ttgJtRGJQctTZtZT").commonItem()).isEqualTo('t')
        assertThat(Rucksack("CrZsJsPPZsGzwwsLwLmpwMDw").commonItem()).isEqualTo('s')
        assertThat(Rucksack("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL").commonItem()).isEqualTo('L')
        assertThat(Rucksack("PmmdzqPrVvPwwTWBwg").commonItem()).isEqualTo('P')
    }

    @Test
    fun `example priorities`() {
        assertThat(Rucksack("vJrwpWtwJgWrhcsFMMfFFhFp").commonItemPriority()).isEqualTo(16)
        assertThat(Rucksack("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn").commonItemPriority()).isEqualTo(22)
        assertThat(Rucksack("ttgJtRGJQctTZtZT").commonItemPriority()).isEqualTo(20)
        assertThat(Rucksack("CrZsJsPPZsGzwwsLwLmpwMDw").commonItemPriority()).isEqualTo(19)
        assertThat(Rucksack("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL").commonItemPriority()).isEqualTo(38)
        assertThat(Rucksack("PmmdzqPrVvPwwTWBwg").commonItemPriority()).isEqualTo(42)
    }
}
