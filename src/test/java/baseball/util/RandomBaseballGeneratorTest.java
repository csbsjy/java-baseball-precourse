package baseball.util;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.BaseballBundle;

class RandomBaseballGeneratorTest {

	@DisplayName("야구공 묶음을 생성한다")
	@Test
	void generate() {
		BaseballBundle baseBallBundle = RandomBaseballGenerator.generate();

		assertThat(baseBallBundle).isNotNull();
	}
}