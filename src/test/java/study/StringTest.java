/**
 * @(#)StringTest.java 2022. 04. 12
 * <p>
 * Copyright 2022 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package study;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author csbsjy
 */
class StringTest {

	@DisplayName("요구사항1) ,로 구분된 숫자들을 배열로 분리한다.")
	@Test
	void split() {
		String delimiter = ",";

		assertAll(
			() -> assertThat("1,2".split(delimiter)).containsExactly("1", "2"),
			() -> assertThat("1".split(delimiter)).containsOnly("1")
		);
	}

	@DisplayName("요구사항2) ()를 제거하고 사이의 문자열만 반환한다.")
	@Test
	void substring() {
		String input = "(1,2)";

		assertThat(input.substring(1, 4)).isEqualTo("1,2");
	}

	@DisplayName("요구사항3) 특정 위치의 문자를 가져온다")
	@CsvSource(value = {"abc:0:a", "abc:1:b", "abc:2:c"}, delimiter = ':')
	@ParameterizedTest
	void charAt(String input, int index, char expected) {
		assertThat(input.charAt(index)).isEqualTo(expected);
	}

	@DisplayName("요구사항3) 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 Exception 이 발생한다")
	@Test
	void charAtException() {
		assertAll(
			() -> assertThatThrownBy(() -> "abc".charAt(-1)).isInstanceOf(StringIndexOutOfBoundsException.class),
			() -> assertThatExceptionOfType(IndexOutOfBoundsException.class)
				.isThrownBy(() -> "abc".charAt(3)).withMessage("String index out of range: " + 3)
		);
	}
}