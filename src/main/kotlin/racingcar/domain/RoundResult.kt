package racingcar.domain

data class RoundResult(
    val cars: List<Car>
) {
    fun getWinners(): List<String> {
        val sortedCars = cars.sortedByDescending { it.distance }
        return sortedCars.filter { it.distance == sortedCars[0].distance }
            .map { it.name }
    }
}