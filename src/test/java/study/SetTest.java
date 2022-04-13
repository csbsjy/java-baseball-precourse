/**
 * @(#)SetTest.java 2022. 04. 13
 *
 * Copyright 2022 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author Jaeyeon Seo(KR20144)
 */
class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("set의 원소의 갯수를 구한다. set은 중복을 중복을 허용하지 않는다.")
	@Test
	void size() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@DisplayName("Set에 존재하는지 확인한다")
	@ValueSource(ints = {1, 2, 3})
	@ParameterizedTest
	void contains(int number) {
		assertThat(numbers.contains(number)).isTrue();
	}

	@DisplayName("Set에 존재유무를 확인한다")
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
	@ParameterizedTest
	void contains(int number, boolean expected) {
		assertThat(numbers.contains(number)).isEqualTo(expected);
	}
}