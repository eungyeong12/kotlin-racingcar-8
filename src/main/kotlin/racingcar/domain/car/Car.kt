package racingcar.domain.car

import racingcar.domain.car.dto.CarDto

class Car(
    val name: String,
    private var _distance: Int = 0
) {
    val distance: Int get() = _distance

    fun moveForward() {
        _distance++
    }

    fun toDto() = CarDto(name, distance)
}