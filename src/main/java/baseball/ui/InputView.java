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

/**
 * @author Jaeyeon Seo(KR20144)
 */
public class InputView {
	private InputView() {
	}

	public static List<Integer> requestNumbers() {
		System.out.println("숫자를 입력해주세요 : ");
		int input = Integer.parseInt(Console.readLine());
		final List<Integer> integers = Arrays.asList(input / 100, input / 10 % 10, input % 10);
		System.out.println(integers);
		return integers;
	}
}