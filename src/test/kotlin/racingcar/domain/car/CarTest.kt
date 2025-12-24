package racingcar.domain.car

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `moveForward()를 실행하면, 거리가 1 증가한다`() {
        // given
        val car = Car("pobi")

        // when
        car.moveForward()

        // then
        assertEquals(car.distance, 1)
    }
}