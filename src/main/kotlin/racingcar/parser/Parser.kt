package racingcar.parser

import racingcar.exception.ErrorMessage

object Parser {

    fun parseNumber(input: String, error: ErrorMessage): Int {
        val number = input.toIntOrNull()
        requireNotNull(number) { error.message }
        return number
    }

    fun splitByDelimiter(input: String, delimiter: Char): List<String> {
        return input.split(delimiter)
            .map { it.trim() }
    }
}