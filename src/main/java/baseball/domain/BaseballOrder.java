package baseball.domain;

import java.util.Objects;

public class BaseballOrder {
	private static final int MIN_ORDER = 1;
	private static final int MAX_ORDER = 3;

	private final int order;

	private BaseballOrder(int order) {
		this.order = order;
		if (this.order < MIN_ORDER || this.order > MAX_ORDER) {
			throw new IllegalArgumentException(String.format("야구공은 %d와 %d번째 사이여야합니다. 현재위치: %d", MIN_ORDER, MAX_ORDER, this.order));
		}
	}

	public static BaseballOrder from(final int order) {
		return new BaseballOrder(order);
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BaseballOrder that = (BaseballOrder)o;
		return order == that.order;
	}

	@Override
	public int hashCode() {
		return Objects.hash(order);
	}
}