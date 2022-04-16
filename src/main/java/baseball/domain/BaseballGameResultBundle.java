/**
 * @(#)BaseballGameResultBundle.java 2022. 04. 16
 *
 * Copyright 2022 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package baseball.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jaeyeon Seo(KR20144)
 */
public class BaseballGameResultBundle {
	private final Map<BaseballGameResult, Integer> countByResult = new HashMap<>();

	public BaseballGameResultBundle() {
		init();
	}

	private void init() {
		countByResult.put(BaseballGameResult.STRIKE, 0);
		countByResult.put(BaseballGameResult.BALL, 0);
		countByResult.put(BaseballGameResult.NOTHING, 0);
	}

	public void addResult(BaseballGameResult result) {
		this.countByResult.put(result, countByResult.get(result) + 1);
	}

	public int countBy(BaseballGameResult baseballGameResult) {
		return countByResult.get(baseballGameResult);
	}
}