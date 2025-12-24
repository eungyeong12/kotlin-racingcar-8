package racingcar.domain.racing

import racingcar.domain.car.AttemptCount
import racingcar.domain.car.Cars
import racingcar.domain.racing.dto.Result

class Racing(
    val cars: Cars,
    val AttemptCount: AttemptCount
) {
    fun race(): Result {
        val results = List(AttemptCount.value) {
            playRound()
        }
        val winners = decideWinners(results.last())
        return Result(results, winners)
    }

    private fun playRound(): Round {
        return Round.play(cars, RandomNumberProvider())
    }

    private fun decideWinners(round: Round): List<String> {
        return round.decideWinners()
    }
}