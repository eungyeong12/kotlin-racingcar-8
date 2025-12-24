package racingcar.domain.racing

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberProvider: NumberProvider {
    override fun pick() = Randoms.pickNumberInRange(MIN, MAX)

    companion object {
        private const val MIN = 0
        private const val MAX = 9
    }
}