package racingcar.domain.car

import racingcar.exception.ErrorMessage
import racingcar.util.Util.splitByDelimiter
import racingcar.validator.Validator.validateBlank

@JvmInline
value class CarNames private constructor(
    val value: List<String>
) {
    init {
        value.forEach {
            validateBlank(it, ErrorMessage.BLANK_CAR_NAME)
            require(it.length <= LENGTH) { ErrorMessage.TOO_LONG_CAR_NAME.message }
        }
        require(value.size == value.distinct().size) { ErrorMessage.DUPLICATE_CAR_NAME.message }
    }

    companion object {
        private const val DELIMITER = ','
        private const val LENGTH = 5

        fun from(input: String): CarNames {
            validateBlank(input, ErrorMessage.BLANK_CAR_NAMES_INPUT)
            return CarNames(splitByDelimiter(input, DELIMITER))
        }
    }
}