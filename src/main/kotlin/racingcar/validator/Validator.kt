package racingcar.validator

import racingcar.exception.ErrorMessage

object Validator {

    fun validateNotBlank(input: String, errorMessage: String = ErrorMessage.BLANK_INPUT.errorMessage) {
        require(input.isNotBlank()) { errorMessage }
    }
}