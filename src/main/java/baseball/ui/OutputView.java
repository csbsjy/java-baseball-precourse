/**
 * @(#)OutputView.java 2022. 04. 17
 *
 * Copyright 2022 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package baseball.ui;

import baseball.domain.BaseballGameResult;
import baseball.domain.BaseballGameResultBundle;

public class OutputView {
	private OutputView() {
	}

	public static void printResult(BaseballGameResultBundle resultBundle) {
		int ballCount = resultBundle.countBy(BaseballGameResult.BALL);
		int strikeCount = resultBundle.countBy(BaseballGameResult.STRIKE);
		if (ballCount > 0) {
			System.out.print(String.format("%d볼 ", ballCount));
		}
		if (strikeCount > 0) {
			System.out.print(String.format("%d스트라이크 ", strikeCount));
		}
		System.out.println();
	}

	public static void printFinishGame() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종");
	}
}