package racingcar.domain.racing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingcar.domain.car.AttemptCount
import racingcar.domain.car.CarNames
import racingcar.domain.car.Cars

class RacingTest {

    @Test
    fun `경주 후 차수별 실행 결과가 시도한 횟수만큼 생성되며, 우승자가 존재한다`() {
        // given
        val cars = Cars.from(CarNames.from("pobi,woni"))
        val attemptCount = AttemptCount.from("5")

        // when
        val racing = Racing(cars, attemptCount)
        val result = racing.race()
        val results = result.results
        val winners = result.winners

        // then
        assertEquals(results.size, 5)
        assertTrue(winners.isNotEmpty())
    }
}