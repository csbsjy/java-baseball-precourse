package baseball;

import java.util.List;

import baseball.domain.BaseballBundle;
import baseball.domain.BaseballGameResultBundle;
import baseball.ui.InputView;
import baseball.ui.OutputView;
import baseball.util.RandomBaseballGenerator;

public class Application {
	public static void main(String[] args) {
		boolean againGame = true;
		boolean finishGame = false;

		while (againGame) {
			BaseballBundle computerBundle = RandomBaseballGenerator.generate();
			while (!finishGame) {
				List<Integer> numbers = InputView.requestNumbers();
				BaseballBundle userBalls = makeBaseballBundle(numbers);

				BaseballGameResultBundle baseballGameResultBundle = computerBundle.compareWith(userBalls);
				OutputView.printResult(baseballGameResultBundle);
				finishGame = baseballGameResultBundle.finish();
				againGame = again();
			}
		}
	}

	private static boolean again() {
		OutputView.printFinishGame();
		return InputView.askAgainGame() == 1;
	}

	private static BaseballBundle makeBaseballBundle(List<Integer> numbers) {
		return BaseballBundle.from(numbers);
	}
}
