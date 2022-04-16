/**
 * @(#)BaseballNumber.java 2022. 04. 16
 *
 * Copyright 2022 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package baseball.domain;

import java.util.Objects;

/**
 * @author Jaeyeon Seo(KR20144)
 */
public class BaseballNumber {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	private final int number;

	private BaseballNumber(final int number) {
		this.number = number;
		if (this.number < MIN_NUMBER || this.number > MAX_NUMBER) {
			throw new IllegalArgumentException(String.format("야구공의 숫자는 %d와 %d 사이여야합니다. 현재숫자: %d", MIN_NUMBER, MAX_NUMBER, this.number));
		}
	}

	public static BaseballNumber from(final int number) {
		return new BaseballNumber(number);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BaseballNumber that = (BaseballNumber)o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}