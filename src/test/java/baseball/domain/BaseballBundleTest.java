package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballBundleTest {

	@DisplayName("야구공이 세개가 아니면 Exception을 던진다")
	@Test
	void exceptionCount() {
		assertThatThrownBy(() -> BaseballBundle.from(Arrays.asList(1, 2)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("야구공이 세개여야 합니다. 현재 갯수: 2");
	}

	@DisplayName("야구공 묶음 두개를 비교해서 결과 묶음을 반환한다")
	@Test
	void compare() {
		//given
		BaseballBundle computerBalls = BaseballBundle.from(Arrays.asList(3, 7, 9));
		BaseballBundle userBalls = BaseballBundle.from(Arrays.asList(3, 9, 1));

		//when
		BaseballGameResultBundle baseballGameResultBundle = computerBalls.compareWith(userBalls);

		//then
		assertAll(
			() -> assertThat(baseballGameResultBundle.countBy(BaseballGameResult.STRIKE)).isEqualTo(1),
			() -> assertThat(baseballGameResultBundle.countBy(BaseballGameResult.BALL)).isEqualTo(1),
			() -> assertThat(baseballGameResultBundle.countBy(BaseballGameResult.NOTHING)).isEqualTo(1)
		);
	}
}