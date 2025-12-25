package racingcar.domain.car

class Car(
    val name: String,
    private var _distance: Int = 0
) {
    val distance: Int get() = _distance

    fun moveForward() {
        _distance++
    }
}