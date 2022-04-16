package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballBundle {
	private static final int BALL_COUNT = 3;

	private final Set<Baseball> baseballs;

	private BaseballBundle(List<Integer> numbers) {
		Set<Baseball> baseballs = new HashSet<>();
		for (int i = 0; i < numbers.size(); i++) {
			baseballs.add(Baseball.from(i + 1, numbers.get(i)));
		}
		this.baseballs = baseballs;
		checkUniqueBallCounts(baseballs);
	}

	public static BaseballBundle from(List<Integer> baseballs) {
		return new BaseballBundle(baseballs);
	}

	public BaseballGameResultBundle compareWith(BaseballBundle inputBaseballs) {
		BaseballGameResultBundle baseballGameResultBundle = new BaseballGameResultBundle();
		for (Baseball another : inputBaseballs.baseballs) {
			BaseballGameResult result = compareWith(another);
			baseballGameResultBundle.addResult(result);
		}
		return baseballGameResultBundle;
	}

	private BaseballGameResult compareWith(Baseball inputBall) {
		Set<BaseballGameResult> results = new HashSet<>();
		for (Baseball baseball : this.baseballs) {
			results.add(baseball.compareWith(inputBall));
		}
		if (results.contains(BaseballGameResult.STRIKE)) {
			return BaseballGameResult.STRIKE;
		}
		if (results.contains(BaseballGameResult.BALL)) {
			return BaseballGameResult.BALL;
		}
		return BaseballGameResult.NOTHING;
	}

	private void checkUniqueBallCounts(Set<Baseball> baseballs) {
		if (baseballs.size() != BALL_COUNT) {
			throw new IllegalArgumentException(String.format("야구공이 세개여야 합니다. 현재 갯수: %d", baseballs.size()));
		}
	}
}