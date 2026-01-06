package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FixedNumberGenerator(private val number: Int) : NumberGenerator {
    override fun generate() = number
}

class CarTest {

    @Test
    fun `4 이상의 숫자가 주어지면, 자동차가 앞으로 전진한다`() {
        // given
        val car = Car("pobi")
        val numberGenerator = FixedNumberGenerator(4)

        // when
        val resultCar = car.move(numberGenerator)

        // then
        assertEquals(1, resultCar.distance)
    }

    @Test
    fun `4보다 작은 숫자가 주어지면, 자동차가 전진하지 않는다`() {
        // given
        val car = Car("pobi")
        val numberGenerator = FixedNumberGenerator(3)

        // when
        val resultCar = car.move(numberGenerator)

        // then
        assertEquals(0, resultCar.distance)
    }
}