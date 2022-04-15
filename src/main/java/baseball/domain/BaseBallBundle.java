/**
 * @(#)BaseBallBundle.java 2022. 04. 16
 *
 * Copyright 2022 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BaseBallBundle {
	private static final int BALL_COUNT = 3;

	private final List<BaseBall> baseBalls;

	private BaseBallBundle(Set<BaseBall> baseBalls) {
		this.baseBalls = new ArrayList<>(baseBalls);
		checkUniqueBallNumbers(baseBalls);
	}

	public static BaseBallBundle from(Set<BaseBall> baseBalls) {
		return new BaseBallBundle(baseBalls);
	}

	public static boolean validToCreate(Set<BaseBall> baseBalls) {
		return baseBalls.size() == 3;
	}

	private void checkUniqueBallNumbers(Set<BaseBall> baseBalls) {
		if (baseBalls.size() != BALL_COUNT) {
			throw new IllegalArgumentException(String.format("야구공이 세개여야 합니다. 현재 갯수: %d", baseBalls.size()));
		}
	}
}