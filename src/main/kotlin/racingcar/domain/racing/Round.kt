package racingcar.domain.racing

import racingcar.domain.car.Car
import racingcar.domain.car.Cars

class Round private constructor(
    val cars: List<Car>
) {
    fun decideWinners(): List<String> {
        val cars = carSortedByDistance()
        return cars.filter {
            hasSameDistance(cars[0], it)
        }.map {
            it.name
        }
    }

    private fun carSortedByDistance(): List<Car> {
        return cars.sortedWith(compareBy { it.distance })
    }

    private fun hasSameDistance(first: Car, second: Car): Boolean {
        return first.distance == second.distance
    }

    companion object {
        fun play(cars: Cars, numberProvider: NumberProvider): Round {
            return Round(cars.moveCars(numberProvider))
        }
    }
}