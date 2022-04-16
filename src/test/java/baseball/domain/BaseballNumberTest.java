package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballNumberTest {

	@DisplayName("야구공은 1과 9사이의 숫자가 아니면 Exception을 던진다")
	@ValueSource(ints = {-1, 0, 10})
	@ParameterizedTest
	void exception(int number) {
		assertThatThrownBy(() -> BaseballNumber.from(number))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(String.format("야구공의 숫자는 %d와 %d 사이여야합니다. 현재숫자: %d", 1, 9, number));
	}
}