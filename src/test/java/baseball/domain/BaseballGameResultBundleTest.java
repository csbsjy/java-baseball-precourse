package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameResultBundleTest {

	@DisplayName("이미 결과가 세개 이상인 결과 번들에 결과를 추가하면 Exception")
	@Test
	void exception() {
		// given
		BaseballGameResultBundle baseballGameResultBundle = new BaseballGameResultBundle();
		baseballGameResultBundle.addResult(BaseballGameResult.STRIKE);
		baseballGameResultBundle.addResult(BaseballGameResult.STRIKE);
		baseballGameResultBundle.addResult(BaseballGameResult.STRIKE);

		// when, then
		assertThatThrownBy(() -> baseballGameResultBundle.addResult(BaseballGameResult.STRIKE))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(String.format("결과는 총 %d개 여야 합니다", 3));
	}
}