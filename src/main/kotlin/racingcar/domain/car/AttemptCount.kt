package racingcar.domain.car

import racingcar.exception.ErrorMessage
import racingcar.parser.Parser.parseNumber
import racingcar.validator.Validator.validateBlank

@JvmInline
value class AttemptCount private constructor(
    val value: Int
) {
    init {
        require(value >= MIN) { ErrorMessage.TOO_SMALL_ATTEMPT_COUNT.message }
    }

    companion object {
        private const val MIN = 1

        fun from(input: String): AttemptCount {
            validateBlank(input, ErrorMessage.BLANK_ATTEMPT_COUNT)
            return AttemptCount(parseNumber(input, ErrorMessage.ATTEMPT_COUNT_NOT_INTEGER))
        }
    }
}