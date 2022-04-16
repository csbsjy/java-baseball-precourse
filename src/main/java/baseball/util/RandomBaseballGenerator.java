package baseball.util;

import baseball.domain.BaseballBundle;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomBaseballGenerator {
	private RandomBaseballGenerator() {
	}

	public static BaseballBundle generate() {
		return BaseballBundle.from(Randoms.pickUniqueNumbersInRange(1, 9, 3));
	}
}