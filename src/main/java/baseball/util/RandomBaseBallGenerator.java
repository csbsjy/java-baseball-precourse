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

import baseball.domain.BaseBall;
import baseball.domain.BaseBallBundle;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomBaseBallGenerator {
	private static final List<Integer> NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

	private RandomBaseBallGenerator() {
	}

	public static BaseBallBundle generate() {
		Set<BaseBall> baseBalls = Sets.newHashSet();
		while (!BaseBallBundle.validToCreate(baseBalls)) {
			baseBalls.add(BaseBall.from(Randoms.pickNumberInList(NUMBERS)));
		}
		return BaseBallBundle.from(baseBalls);
	}
}