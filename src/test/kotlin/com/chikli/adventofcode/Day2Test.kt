package com.chikli.adventofcode

import com.chikli.adventofcode.Rps.Companion.paper
import com.chikli.adventofcode.Rps.Companion.rock
import com.chikli.adventofcode.Rps.Companion.scissors
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day2Test {

    @Test
    fun `example scores`() {
        assertThat(RpsStrategyEntry(rock, paper).score()).isEqualTo(8)
        assertThat(RpsStrategyEntry(paper, rock).score()).isEqualTo(1)
        assertThat(RpsStrategyEntry(scissors, scissors).score()).isEqualTo(6)
        assertThat(RpsStrategyEntry(rock, scissors).score()).isEqualTo(3)
    }
}
