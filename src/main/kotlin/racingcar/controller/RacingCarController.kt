package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.RandomNumberGenerator
import racingcar.domain.RoundResult
import racingcar.parser.Parser.parseToNumber
import racingcar.parser.Parser.splitByDelimiter
import racingcar.validator.Validator.validateNotBlank
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController {

    fun run() {
        val cars = getCars()
        val attemptCount = getAttemptCount()
        val numberGenerator = RandomNumberGenerator()
        val results = List(attemptCount) {
            RoundResult(cars.map { it.move(numberGenerator) })
        }
        OutputView.printResult(results, results.last().getWinners())
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

    private fun getAttemptCount(): Int {
        val input = readNotBlankInput()
        val number = parseToNumber(input)
        require(number >= 1) { "[ERROR] 시도할 횟수는 1회 이상이어야 합니다." }
        return number
    }

    private fun readNotBlankInput(): String {
        val input = InputView.readInput()
        validateNotBlank(input)
        return input
    }
}