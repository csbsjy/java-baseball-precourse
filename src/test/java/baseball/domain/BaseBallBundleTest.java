package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Jaeyeon Seo(KR20144)
 */
class BaseBallBundleTest {

	@DisplayName("야구공이 세개가 아니면 Exception을 던진다")
	@Test
	void exceptionCount() {
		assertThatThrownBy(() -> BaseBallBundle.from(Arrays.asList(BaseBall.from(1), BaseBall.from(2))))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("야구공이 세개여야 합니다. 현재 갯수: 2");
	}

	@DisplayName("같은 수의 야구 공이 있으면 Exception을 던진다")
	@Test
	void exception() {
		assertThatThrownBy(() -> BaseBallBundle.from(Arrays.asList(BaseBall.from(1), BaseBall.from(1), BaseBall.from(2))))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("야구공은 서로 다른 수로만 이루어져야 합니다");
	}
}