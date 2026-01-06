package racingcar.view

import racingcar.domain.RoundResult

object OutputView {

    fun printResult(results: List<RoundResult>, winners: List<String>) {
        println()
        println("실행 결과")
        println(results.joinToString("\n") {
            it.cars.joinToString("\n") { car ->
                "${car.name} : ${"-".repeat(car.distance)}"
            }
        })
        println()
        println("최종 우승자 : ${winners.joinToString(", ") { it }}")
    }

    fun printErrorMessage(errorMessage: String) {
        println()
        println(errorMessage)
    }
}