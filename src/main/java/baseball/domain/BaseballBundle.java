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

public class BaseballBundle {
	private static final int BALL_COUNT = 3;

	private final List<Baseball> baseballs;

	private BaseballBundle(Set<Baseball> baseballs) {
		this.baseballs = new ArrayList<>(baseballs);
		checkUniqueBallNumbers(baseballs);
	}

	public static BaseballBundle from(Set<Baseball> baseballs) {
		return new BaseballBundle(baseballs);
	}

	public static boolean validToCreate(Set<Baseball> baseballs) {
		return baseballs.size() == 3;
	}

	private void checkUniqueBallNumbers(Set<Baseball> baseballs) {
		if (baseballs.size() != BALL_COUNT) {
			throw new IllegalArgumentException(String.format("야구공이 세개여야 합니다. 현재 갯수: %d", baseballs.size()));
		}
	}
}