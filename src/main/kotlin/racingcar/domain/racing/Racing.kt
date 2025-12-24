package racingcar.domain.racing

import racingcar.domain.car.AttemptCount
import racingcar.domain.car.Cars
import racingcar.domain.racing.dto.Result

class Racing(
    val cars: Cars,
    val attemptCount: AttemptCount
) {
    fun race(numberProvider: NumberProvider): Result {
        val results = List(attemptCount.value) {
            playRound(numberProvider)
        }
        val winners = decideWinners(results.last())
        return Result(results, winners)
    }

    private fun playRound(numberProvider: NumberProvider): Round {
        return Round.play(cars, numberProvider)
    }

    private fun decideWinners(round: Round): List<String> {
        return round.decideWinners()
    }
}