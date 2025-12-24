package racingcar.util

object Util {

    fun splitByDelimiter(input: String, delimiter: Char): List<String> {
        return input.split(delimiter)
            .map { it.trim() }
    }
}