package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballTest {
	@DisplayName("야구공끼리 비교해서 결과를 반환한다")
	@Test
	void compare() {
		assertAll(
			() -> assertThat(Baseball.from(1, 1).compareWith(Baseball.from(1, 1))).isEqualTo(BaseballGameResult.STRIKE),
			() -> assertThat(Baseball.from(1, 1).compareWith(Baseball.from(2, 1))).isEqualTo(BaseballGameResult.BALL),
			() -> assertThat(Baseball.from(1, 1).compareWith(Baseball.from(2, 2))).isEqualTo(BaseballGameResult.NOTHING)
		);
	}
}