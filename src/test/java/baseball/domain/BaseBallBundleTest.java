package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallBundleTest {

	@DisplayName("야구공이 세개가 아니면 Exception을 던진다")
	@Test
	void exceptionCount() {
		assertThatThrownBy(() -> BaseBallBundle.from(Sets.newHashSet(Arrays.asList(BaseBall.from(1), BaseBall.from(2)))))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("야구공이 세개여야 합니다. 현재 갯수: 2");
	}
}