package racingcar.domain.racing

import racingcar.domain.car.Cars
import racingcar.domain.car.dto.CarDto

class Round private constructor(
    val cars: List<CarDto>
) {
    fun decideWinners(): List<String> {
        val cars = carSortedByDistance()
        return cars.filter {
            hasSameDistance(cars[0], it)
        }.map {
            it.name
        }
    }

    private fun carSortedByDistance(): List<CarDto> {
        return cars.sortedByDescending { it.distance }
    }

    private fun hasSameDistance(first: CarDto, second: CarDto): Boolean {
        return first.distance == second.distance
    }

    companion object {
        fun play(cars: Cars, numberProvider: NumberProvider): Round {
            return Round(cars.moveCars(numberProvider))
        }
    }
}