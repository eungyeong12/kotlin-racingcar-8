package racingcar.exception

enum class ErrorMessage(val message: String) {
    BLANK_CAR_NAMES_INPUT("자동차 이름을 입력해 주세요."),
    BLANK_CAR_NAME("자동차 이름이 비어 있습니다."),
    TOO_LONG_CAR_NAME("자동차 이름은 5자 이하여야 합니다."),
    DUPLICATE_CAR_NAME("자동차의 이름은 중복될 수 없습니다.")
}