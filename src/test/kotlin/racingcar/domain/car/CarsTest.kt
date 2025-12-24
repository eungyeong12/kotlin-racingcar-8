package racingcar.domain.car

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingcar.domain.racing.NumberProvider

class FixedNumberProvider(private val number: Int): NumberProvider {
    override fun pick() = number
}

class CarsTest {

    @Test
    fun `모든 차의 거리를 1만큼 전진시킨다`() {
        // given
        val numberProvider = FixedNumberProvider(4)
        val cars = Cars.from(CarNames.from("pobi,woni"))

        // when
        cars.moveCars(numberProvider)

        // then
        assertTrue(cars.cars.all { it.distance == 1 })
    }
}