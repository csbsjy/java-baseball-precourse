/**
 * @(#)BaseBall.java 2022. 04. 16
 *
 * Copyright 2022 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package baseball.domain;

/**
 * @author Jaeyeon Seo(KR20144)
 */
public class BaseBall {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private final int number;

	private BaseBall(int number) {
		this.number = number;
		if (number < MIN_NUMBER || number > MAX_NUMBER) {
			throw new IllegalArgumentException(String.format("야구공의 숫자는 %d와 %d여야합니다. 현재숫자: %d", MIN_NUMBER, MAX_NUMBER, number));
		}
	}

	public static BaseBall from(int number) {
		return new BaseBall(number);
	}
}