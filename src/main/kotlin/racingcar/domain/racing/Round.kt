package racingcar.domain.racing

import racingcar.domain.car.Cars
import racingcar.domain.car.dto.CarSnapShot

class Round private constructor(
    val cars: List<CarSnapShot>
) {
    fun decideWinners(): List<String> {
        val cars = carSortedByDistance()
        return cars.filter {
            hasSameDistance(cars[0], it)
        }.map {
            it.name
        }
    }

    private fun carSortedByDistance(): List<CarSnapShot> {
        return cars.sortedByDescending { it.distance }
    }

    private fun hasSameDistance(first: CarSnapShot, second: CarSnapShot): Boolean {
        return first.distance == second.distance
    }

    companion object {
        fun play(cars: Cars, numberProvider: NumberProvider): Round {
            return Round(cars.moveCars(numberProvider))
        }
    }
}