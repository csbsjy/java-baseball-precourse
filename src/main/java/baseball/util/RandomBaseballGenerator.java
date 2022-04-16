/**
 * @(#)RandomBallGenerator.java 2022. 04. 16
 *
 * Copyright 2022 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
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