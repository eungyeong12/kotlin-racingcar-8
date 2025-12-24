package racingcar.domain

class Cars private constructor(
    val cars: List<Car>
) {

    companion object {

        fun from(input: CarNames): Cars {
            return Cars(input.value.map { Car(it) })
        }
    }
}