package racingcar.controller

import racingcar.domain.CarNames
import racingcar.domain.Cars
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController {

    fun run() {
        OutputView.displayCarNamesPrompt()
        val names = CarNames.from(InputView.readInput())
        val cars = Cars.from(names)
    }
}