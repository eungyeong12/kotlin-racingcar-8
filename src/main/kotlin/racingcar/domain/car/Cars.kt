package racingcar.domain.car

import racingcar.domain.car.dto.CarSnapShot
import racingcar.domain.racing.NumberProvider

class Cars private constructor(
    val cars: List<Car>
) {
    fun moveCars(numberProvider: NumberProvider): List<CarSnapShot> {
        return cars.map {
            moveCar(it, numberProvider.pick())
            CarSnapShot(it.name, it.distance)
        }
    }

    private fun moveCar(car: Car, number: Int) {
        if (number >= THRESHOLD) {
            car.moveForward()
        }
    }

    companion object {
        private const val THRESHOLD = 4

        fun from(input: CarNames): Cars {
            return Cars(input.value.map { Car(it) })
        }
    }
}