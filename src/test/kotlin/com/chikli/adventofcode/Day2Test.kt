package com.chikli.adventofcode

import com.chikli.adventofcode.Outcome.DRAW
import com.chikli.adventofcode.Outcome.LOSE
import com.chikli.adventofcode.Outcome.WIN
import com.chikli.adventofcode.Rps.Companion.paper
import com.chikli.adventofcode.Rps.Companion.rock
import com.chikli.adventofcode.Rps.Companion.scissors
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day2Test {

    @Test
    fun `example scores`() {
        assertThat(RpsStrategyEntry(rock, DRAW).score()).isEqualTo(4)
        assertThat(RpsStrategyEntry(paper, LOSE).score()).isEqualTo(1)
        assertThat(RpsStrategyEntry(scissors, WIN).score()).isEqualTo(7)
        assertThat(RpsStrategyEntry(rock, LOSE).score()).isEqualTo(3)
    }
}
