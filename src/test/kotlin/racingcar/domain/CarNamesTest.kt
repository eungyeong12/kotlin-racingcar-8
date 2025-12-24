package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.exception.ErrorMessage

class CarNamesTest {

    @Test
    fun `정상적인 입력이 들어올 경우, CarNames 객체가 생성된다`() {
        // given
        val input = "pobi,woni, jun"

        // when
        val names = CarNames.from(input).value

        // then
        assertEquals(names.size, 3)
        assertEquals(names[0], "pobi")
        assertEquals(names[1], "woni")
        assertEquals(names[2], "jun")
    }

    @Test
    fun `입력이 비어 있을 경우, 에러 메시지가 던져진다`() {
        // given
        val input = ""

        // when
        val exception = assertThrows<IllegalArgumentException> { CarNames.from(input) }

        // then
        assertEquals(exception.message, ErrorMessage.BLANK_CAR_NAMES_INPUT.message)
    }

    @Test
    fun `비어 있는 이름이 있을 경우, 에러 메시지가 던져진다`() {
        // given
        val input = "pobi, ,jun"

        // when
        val exception = assertThrows<IllegalArgumentException> { CarNames.from(input) }

        // then
        assertEquals(exception.message, ErrorMessage.BLANK_CAR_NAME.message)
    }

    @Test
    fun `5자보다 긴 이름이 있을 경우, 에러 메시지가 던져진다`() {
        // given
        val input = "eungyeong, pobi"

        // when
        val exception = assertThrows<IllegalArgumentException> { CarNames.from(input) }

        // then
        assertEquals(exception.message, ErrorMessage.TOO_LONG_CAR_NAME.message)
    }

    @Test
    fun `중복되는 이름이 있을 경우, 에러 메시지가 던져진다`() {
        // given
        val input = "pobi, pobi"

        // when
        val exception = assertThrows<IllegalArgumentException> { CarNames.from(input) }

        // then
        assertEquals(exception.message, ErrorMessage.DUPLICATE_CAR_NAME.message)
    }
}