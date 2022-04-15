/**
 * @(#)RandomBallGenerator.java 2022. 04. 16
 *
 * Copyright 2022 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package baseball.util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.assertj.core.util.Sets;

import baseball.domain.Baseball;
import baseball.domain.BaseballBundle;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomBaseballGenerator {
	private static final List<Integer> NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

	private RandomBaseballGenerator() {
	}

	public static BaseballBundle generate() {
		Set<Baseball> baseballs = Sets.newHashSet();
		while (!BaseballBundle.validToCreate(baseballs)) {
			baseballs.add(Baseball.from(baseballs.size() + 1, Randoms.pickNumberInList(NUMBERS)));
		}
		return BaseballBundle.from(baseballs);
	}
}