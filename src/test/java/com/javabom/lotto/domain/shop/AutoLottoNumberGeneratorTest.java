package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.number.GameNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutoLottoNumberGeneratorTest {

    @DisplayName("자동으로 생성된 로또 숫자들의 범위를 확인한다.")
    @Test
    void generate(){
        AutoLottoNumberGenerator autoLottoNumberGenerator = new AutoLottoNumberGenerator();
        List<GameNumber> actual = autoLottoNumberGenerator.generate();

        assertTrue(actual.get(0).value() >= GameNumber.MIN_NUMBER && actual.get(0).value() <= GameNumber.MAX_NUMBER);
        assertTrue(actual.get(1).value() >= GameNumber.MIN_NUMBER && actual.get(1).value() <= GameNumber.MAX_NUMBER);
        assertTrue(actual.get(2).value() >= GameNumber.MIN_NUMBER && actual.get(2).value() <= GameNumber.MAX_NUMBER);
        assertTrue(actual.get(3).value() >= GameNumber.MIN_NUMBER && actual.get(3).value() <= GameNumber.MAX_NUMBER);
        assertTrue(actual.get(4).value() >= GameNumber.MIN_NUMBER && actual.get(4).value() <= GameNumber.MAX_NUMBER);
        assertTrue(actual.get(5).value() >= GameNumber.MIN_NUMBER && actual.get(5).value() <= GameNumber.MAX_NUMBER);
    }
}
