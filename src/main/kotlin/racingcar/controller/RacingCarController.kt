package racingcar.controller

import racingcar.domain.Car
import racingcar.parser.Parser.splitByDelimiter
import racingcar.validator.Validator.validateNotBlank
import racingcar.view.InputView

class RacingCarController {

    fun run() {
        val cars = getCars()
    }

    private fun getCars(): List<Car> {
        val input = readNotBlankInput()
        val cars = splitByDelimiter(input, ',')
            .map {
                require(it.length <= 5) { "[ERROR] 이름은 5자 이하여야 합니다." }
                Car(it)
            }
        require(cars.size >= 2) { "[ERROR] 자동차는 2대 이상이어야 합니다." }
        return cars
    }

    private fun readNotBlankInput(): String {
        val input = InputView.readInput()
        validateNotBlank(input)
        return input
    }
}