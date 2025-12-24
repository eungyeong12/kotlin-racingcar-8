package racingcar.domain.racing.dto

import racingcar.domain.racing.Round

data class Result(
    val results: List<Round>,
    val winners: List<String>
)