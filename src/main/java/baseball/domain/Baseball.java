/**
 * @(#)BaseBall.java 2022. 04. 16
 *
 * Copyright 2022 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package baseball.domain;

public class Baseball {
	private final BaseballOrder order; // Domain 으로 빼기
	private final BaseballNumber number;

	private Baseball(int order, int number) {
		this.order = BaseballOrder.from(order);
		this.number = BaseballNumber.from(number);

	}

	public static Baseball from(int order, int number) {
		return new Baseball(order, number);
	}

	public BaseballGameResult compareWith(Baseball baseball) {
		if (equalsExactly(baseball)) {
			return BaseballGameResult.STRIKE;
		}
		if (equalsNumber(baseball)) {
			return BaseballGameResult.BALL;
		}
		return BaseballGameResult.NOTHING;
	}

	private boolean equalsExactly(Baseball baseball) {
		return equalsNumber(baseball) && this.order.equals(baseball.order);
	}

	private boolean equalsNumber(Baseball baseball) {
		return this.number.equals(baseball.number);
	}
}