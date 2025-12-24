package racingcar.view

import racingcar.domain.racing.Round
import racingcar.domain.racing.dto.Result

object OutputView {
    private const val CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    private const val ATTEMPT_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?"
    private const val RESULT_PROMPT = "실행 결과"
    private const val WINNER_PROMPT = "최종 우승자 :"

    fun displayCarNamesPrompt() {
        println(CAR_NAMES_PROMPT)
    }

    fun displayAttemptCountPrompt() {
        println(ATTEMPT_COUNT_PROMPT)
    }

    fun displayRacingResult(result: Result) {
        println(RESULT_PROMPT)
        println(formatRoundResults(result.results))
        println()
        println("$WINNER_PROMPT ${formatWinners(result.winners)}")
    }

    private fun formatRoundResults(rounds: List<Round>): String {
        return rounds.joinToString("\n\n") { round ->
            formatRoundResult(round)
        }
    }

    private fun formatRoundResult(round: Round): String {
        return round.cars.joinToString("\n") { car ->
            "${car.name} : ${"-".repeat(car.distance)}"
        }
    }

    private fun formatWinners(winners: List<String>): String {
        return winners.joinToString(", ")
    }
}