package racingcar.validator

import racingcar.exception.ErrorMessage

object Validator {

    fun validateBlank(input: String, error: ErrorMessage) {
        require(input.isNotBlank()) { error.message }
    }
}