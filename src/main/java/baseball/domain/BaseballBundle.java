/**
 * @(#)BaseBallBundle.java 2022. 04. 16
 *
 * Copyright 2022 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package baseball.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BaseballBundle {
	private static final int BALL_COUNT = 3;

	private final Set<Baseball> baseballs;

	private BaseballBundle(Set<Baseball> baseballs) {
		this.baseballs = baseballs;
		checkUniqueBallNumbers(baseballs);
	}

	public static BaseballBundle from(Set<Baseball> baseballs) {
		return new BaseballBundle(baseballs);
	}

	public static boolean validToCreate(Set<Baseball> baseballs) {
		return baseballs.size() == 3;
	}

	// TODO T.C
	public BaseballGameResultBundle compareWith(BaseballBundle baseballBundle) {
		Map<BaseballGameResult, Integer> results = new HashMap<>();
		for (Baseball baseball : baseballs) {
			// TODO: 수정
			for (Baseball another : baseballBundle.baseballs) {
				results.put(baseball.compareWith(another), results.get(baseball.compareWith(another)) + 1);
			}
		}
		return BaseballGameResultBundle.from(results);
	}

	private void checkUniqueBallNumbers(Set<Baseball> baseballs) {
		if (baseballs.size() != BALL_COUNT) {
			throw new IllegalArgumentException(String.format("야구공이 세개여야 합니다. 현재 갯수: %d", baseballs.size()));
		}
	}
}