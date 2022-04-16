package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballOrderTest {

	@DisplayName("야구공은 1-3번째 순서에 위치하지 않으면 Exception 을 던진다")
	@ValueSource(ints = {-1, 0, 4})
	@ParameterizedTest
	void exceptionOrder(int order) {
		assertThatThrownBy(() -> BaseballOrder.from(order))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(String.format("야구공은 %d와 %d번째 사이여야합니다. 현재위치: %d", 1, 3, order));
	}
}