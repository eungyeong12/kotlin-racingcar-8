package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SequenceNumberGenerator(numbers: List<Int>) : NumberGenerator {
    private val queue = ArrayDeque(numbers)

    override fun generate(): Int {
        if (queue.isEmpty()) return 0
        return queue.removeFirst()
    }
}

class RoundResultTest {

    @Test
    fun `우승자를 올바르게 판단한다`() {
        // given
        val cars = listOf(Car("pobi"), Car("woni"), Car("jun"))
        val numberGenerator = SequenceNumberGenerator(listOf(3, 4, 4))
        val roundResult = RoundResult(cars.map { it.move(numberGenerator) })

        // when
        val winners = roundResult.getWinners()

        // then
        assertEquals("woni", winners[0])
        assertEquals("jun", winners[1])
    }
}