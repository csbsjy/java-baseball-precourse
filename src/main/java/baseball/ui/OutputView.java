/**
 * @(#)OutputView.java 2022. 04. 17
 *
 * Copyright 2022 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package baseball.ui;

import baseball.domain.BaseballGameResult;
import baseball.domain.BaseballGameResultBundle;

/**
 * @author Jaeyeon Seo(KR20144)
 */
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
}