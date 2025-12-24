package racingcar.domain.car

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.exception.ErrorMessage

class AttemptCountTest {

    @Test
    fun `정상적인 입력이 들어올 경우, AttemptCount 객체가 생성된다`() {
        // given
        val input = "5"

        // when
        val count = AttemptCount.from(input).value

        // then
        assertEquals(count, 5)
    }

    @Test
    fun `입력이 비어 있을 경우, 에러 메시지가 던져진다`() {
        // given
        val input = ""

        // when
        val exception = assertThrows<IllegalArgumentException> { AttemptCount.from(input) }

        // then
        assertEquals(exception.message, ErrorMessage.BLANK_ATTEMPT_COUNT.message)
    }

    @Test
    fun `시도할 횟수가 정수가 아닐 경우, 에러 메시지가 던져진다`() {
        // given
        val input = "a"

        // when
        val exception = assertThrows<IllegalArgumentException> { AttemptCount.from(input) }

        // then
        assertEquals(exception.message, ErrorMessage.ATTEMPT_COUNT_NOT_INTEGER.message)
    }

    @Test
    fun `시도할 횟수가 1 이상이 아닐 경우, 에러 메시지가 던져진다`() {
        // given
        val input = "0"

        // when
        val exception = assertThrows<IllegalArgumentException> { AttemptCount.from(input) }

        // then
        assertEquals(exception.message, ErrorMessage.TOO_SMALL_ATTEMPT_COUNT.message)
    }
}