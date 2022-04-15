/**
 * @(#)RandomBallGenerator.java 2022. 04. 16
 *
 * Copyright 2022 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package baseball.util;

import java.util.Arrays;
import java.util.List;

import baseball.domain.BaseBallBundle;
import camp.nextstep.edu.missionutils.Randoms;

/**
 * @author Jaeyeon Seo(KR20144)
 */
public class RandomBallGenerator {
	private RandomBallGenerator() {
	}

	public BaseBallBundle generate() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Randoms.pickNumberInList(numbers);
		return BaseBallBundle.from(null);
	}
}