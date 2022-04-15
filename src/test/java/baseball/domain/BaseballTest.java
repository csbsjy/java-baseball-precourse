package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballTest {

	@DisplayName("야구공은 1과 9사이의 숫자가 아니면 Exception을 던진다")
	@ValueSource(ints = {-1, 0, 10})
	@ParameterizedTest
	void exception(int number) {
		assertThatThrownBy(() -> Baseball.from(1, number))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(String.format("야구공의 숫자는 %d와 %d여야합니다. 현재숫자: %d", 1, 9, number));
	}

	@DisplayName("야구공은 1-3번째 순서에 위치하지 않으면 Exception 을 던진다")
	@ValueSource(ints = {-1, 0, 4})
	@ParameterizedTest
	void exceptionOrder(int order) {
		assertThatThrownBy(() -> Baseball.from(order, 3))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(String.format("야구공은 %d와 %d번째 사이여야합니다. 현재위치: %d", 1, 3, order));
	}

	@DisplayName("야구공의 순서가 달라도 숫자가 같으면 같은 야구공으로 판단한다")
	@Test
	void equals() {
		assertThat(Baseball.from(1, 3)).isEqualTo(Baseball.from(3, 3));
	}

	@DisplayName("순서와 숫자를 정확하게 비교한다")
	@Test
	void equalsExactly() {
		assertAll(
			() -> assertThat(Baseball.from(1, 3).equalsExactly(Baseball.from(1, 3))).isTrue(),
			() -> assertThat(Baseball.from(1, 3).equalsExactly(Baseball.from(1, 2))).isFalse(),
			() -> assertThat(Baseball.from(1, 3).equalsExactly(Baseball.from(2, 3))).isFalse());
	}
}