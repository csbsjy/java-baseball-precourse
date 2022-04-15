/**
 * @(#)BaseBallBundle.java 2022. 04. 16
 *
 * Copyright 2022 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jaeyeon Seo(KR20144)
 */
public class BaseBallBundle {
	private static final int BALL_COUNT = 3;

	private final List<BaseBall> baseBalls;

	private BaseBallBundle(List<BaseBall> baseBalls) {
		this.baseBalls = baseBalls;
		checkUniqueBallNumbers(baseBalls);
	}

	public static BaseBallBundle from(List<BaseBall> baseBalls) {
		return new BaseBallBundle(baseBalls);
	}

	private void checkUniqueBallNumbers(List<BaseBall> baseBalls) {
		if (baseBalls.size() != BALL_COUNT) {
			throw new IllegalArgumentException(String.format("야구공이 세개여야 합니다. 현재 갯수: %d", baseBalls.size()));
		}

		Set<BaseBall> uniqueBalls = new HashSet<>(baseBalls);
		if (uniqueBalls.size() != baseBalls.size()) {
			throw new IllegalArgumentException("야구공은 서로 다른 수로만 이루어져야 합니다");
		}
	}
}