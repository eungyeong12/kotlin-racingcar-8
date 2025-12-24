package racingcar.domain.racing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingcar.domain.car.AttemptCount
import racingcar.domain.car.CarNames
import racingcar.domain.car.Cars
import racingcar.domain.car.FixedNumberProvider

class RacingTest {

    @Test
    fun `경주의 차수별 실행 결과와 우승자 리스트가 올바르게 생성된다`() {
        // given
        val numberProvider = FixedNumberProvider(4)
        val cars = Cars.from(CarNames.from("pobi,woni"))
        val attemptCount = AttemptCount.from("5")

        // when
        val racing = Racing(cars, attemptCount)
        val result = racing.race(numberProvider)
        val results = result.results
        val winners = result.winners

        // then
        assertEquals(results.size, 5)
        assertTrue { results[0].cars.all { it.distance == 1 }}
        assertTrue { results[1].cars.all { it.distance == 2 }}
        assertTrue { results[2].cars.all { it.distance == 3 }}
        assertTrue { results[3].cars.all { it.distance == 4 }}
        assertTrue { results[4].cars.all { it.distance == 5 }}
        assertEquals(winners, listOf("pobi", "woni"))
    }
}