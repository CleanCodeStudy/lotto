package com.ccstudy.lotto.util;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RandomListGeneratorTest {


    @Test
    public void 임의의_6자리_랜덤_리스트_생성() {
        RandomGeneratorImpl randomListGenerator = new RandomGeneratorImpl();

        List<Integer> random6 = randomListGenerator.getSixList();

        int max = random6.stream()
                .max(Comparator.comparingInt(Integer::byteValue))
                .get();

        int min = random6.stream()
                .min(Comparator.comparingInt(Integer::byteValue))
                .get();

        assertThat(max).isLessThanOrEqualTo(45);
        assertThat(min).isGreaterThanOrEqualTo(1);
    }
}