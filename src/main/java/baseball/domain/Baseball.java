/**
 * @(#)BaseBall.java 2022. 04. 16
 *
 * Copyright 2022 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package baseball.domain;

import java.util.Objects;

public class Baseball {
	private static final int MIN_ORDER = 1;
	private static final int MAX_ORDER = 3;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	private final int order;
	private final int number;

	private Baseball(int order, int number) {
		this.order = order;
		this.number = number;
		if (this.order < MIN_NUMBER || this.order > MAX_ORDER) {
			throw new IllegalArgumentException(String.format("야구공은 %d와 %d번째 사이여야합니다. 현재위치: %d", MIN_ORDER, MAX_ORDER, this.order));
		}
		if (this.number < MIN_NUMBER || this.number > MAX_NUMBER) {
			throw new IllegalArgumentException(String.format("야구공의 숫자는 %d와 %d여야합니다. 현재숫자: %d", MIN_NUMBER, MAX_NUMBER, this.number));
		}
	}

	public static Baseball from(int order, int number) {
		return new Baseball(order, number);
	}

	/**
	 * number가 같으면 같은 Baseball 로 간주한다
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Baseball baseBall = (Baseball)o;
		return number == baseBall.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}