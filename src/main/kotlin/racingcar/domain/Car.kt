package racingcar.domain

data class Car(
    val name: String,
    val distance: Int = 0
) {
    fun move(numberGenerator: NumberGenerator): Car {
        val number = numberGenerator.generate()
        if (number >= 4) {
            return this.copy(distance = distance + 1)
        }
        return this
    }
}