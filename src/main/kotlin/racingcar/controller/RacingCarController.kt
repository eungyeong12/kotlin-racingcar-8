package racingcar.controller

import racingcar.domain.car.AttemptCount
import racingcar.domain.car.CarNames
import racingcar.domain.car.Cars
import racingcar.domain.racing.Racing
import racingcar.domain.racing.RandomNumberProvider
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController {

    fun run() {
        OutputView.displayCarNamesPrompt()
        val names = CarNames.from(InputView.readInput())

        OutputView.displayAttemptCountPrompt()
        val attemptCount = AttemptCount.from(InputView.readInput())

        val cars = Cars.from(names)
        val racing = Racing(cars, attemptCount)
        val result = racing.race(RandomNumberProvider())

        OutputView.displayRacingResult(result)
    }
}