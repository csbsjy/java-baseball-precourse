/**
 * @(#)InputView.java 2022. 04. 17
 *
 * Copyright 2022 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package baseball.ui;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private InputView() {
	}

	public static List<Integer> requestNumbers() {
		System.out.println("숫자를 입력해주세요 : ");
		int input = Integer.parseInt(Console.readLine());
		return Arrays.asList(input / 100, input / 10 % 10, input % 10);
	}

	public static int askAgainGame() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		int response = Integer.parseInt(Console.readLine());
		if (response != 1 && response != 2) {
			throw new IllegalArgumentException("잘못된 입력값입니다");
		}
		return response;
	}
}