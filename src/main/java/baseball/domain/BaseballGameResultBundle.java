/**
 * @(#)BaseballGameResultBundle.java 2022. 04. 16
 *
 * Copyright 2022 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package baseball.domain;

import java.util.Map;

/**
 * @author Jaeyeon Seo(KR20144)
 */
public class BaseballGameResultBundle {
	private final Map<BaseballGameResult, Integer> countByResult;

	private BaseballGameResultBundle(Map<BaseballGameResult, Integer> countByResult) {
		this.countByResult = countByResult;
	}

	public static BaseballGameResultBundle from(Map<BaseballGameResult, Integer> countByResult) {
		return new BaseballGameResultBundle(countByResult);
	}
}