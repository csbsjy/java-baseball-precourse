package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.domain.Baseball;
import baseball.domain.BaseballBundle;
import baseball.domain.BaseballGameResultBundle;
import baseball.ui.InputView;
import baseball.ui.OutputView;
import baseball.util.RandomBaseballGenerator;

public class Application {
	public static void main(String[] args) {

		BaseballBundle computerBundle = RandomBaseballGenerator.generate();

		boolean finishGame = false;

		while (!finishGame) {
			List<Integer> numbers = InputView.requestNumbers();
			BaseballBundle userBalls = makeBaseballBundle(numbers);

			BaseballGameResultBundle baseballGameResultBundle = computerBundle.compareWith(userBalls);
			OutputView.printResult(baseballGameResultBundle);
			finishGame = baseballGameResultBundle.finish();
		}
	}

	private static BaseballBundle makeBaseballBundle(List<Integer> numbers) {
		Set<Baseball> balls = new HashSet<>();
		for (int i = 0; i < numbers.size(); i++) {
			balls.add(Baseball.from(i + 1, numbers.get(i)));
		}
		return BaseballBundle.from(balls);
	}
}
