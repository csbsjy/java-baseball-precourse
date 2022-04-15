package baseball.util;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.BaseBallBundle;

class RandomBaseBallGeneratorTest {

	@DisplayName("세개의 중복되지 않은 수를 가진 야구공 묶음을 생성한다")
	@Test
	void generate() {
		BaseBallBundle baseBallBundle = RandomBaseBallGenerator.generate();

		assertThat(baseBallBundle).isNotNull();
	}

}