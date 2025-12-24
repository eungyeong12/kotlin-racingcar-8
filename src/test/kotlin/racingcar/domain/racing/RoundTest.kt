package racingcar.domain.racing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingcar.domain.car.CarNames
import racingcar.domain.car.Cars
import racingcar.domain.car.FixedNumberProvider

class RoundTest {

    @Test
    fun `한 라운드를 마친 후, 모든 차의 거리가 1만큼 증가된다`() {
        // given
        val numberProvider = FixedNumberProvider(4)
        val cars = Cars.from(CarNames.from("pobi,woni"))

        // when
        val round = Round.play(cars, numberProvider)

        // then
        assertTrue(round.cars.all { it.distance == 1 })
    }

    @Test
    fun `우승자 리스트를 올바르게 반환한다`() {
        // given
        val numberProvider = FixedNumberProvider(4)
        val cars = Cars.from(CarNames.from("pobi,woni"))

        // when
        val round = Round.play(cars, numberProvider)
        val winners = round.decideWinners()

        // then
        assertEquals(winners.size, 2)
        assertEquals(winners[0], "pobi")
        assertEquals(winners[1], "woni")
    }
}