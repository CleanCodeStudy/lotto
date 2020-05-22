package com.javabom.lotto.domain;

import com.javabom.lotto.util.FixedLottoNumber;
import com.javabom.lotto.util.LottoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyLottoBundleTest {

    @DisplayName("나의 로또 번호와 당첨번호의 일치 갯수를 잘 반환하는지 확인한다.")
    @Test
    void getMatchedCounts() {
        MyLottoBundle myLottoBundle = new MyLottoBundle(
                LottoFactory.createLotto(2, new FixedLottoNumber()));

        PrizeNumbers prizeNumbers = new PrizeNumbers(Arrays.asList("1", "2", "3", "4", "5", "6"));
        BonusNumber bonusNumber = new BonusNumber("7", prizeNumbers);

        List<Integer> actual = myLottoBundle.getMatchedCounts(prizeNumbers, bonusNumber);

        assertEquals(6, actual.get(0));
        assertEquals(6, actual.get(1));
    }

    @DisplayName("입력한 로또 값들이 잘 들어왔는지 확인한다.")
    @Test
    public void getMyLottoBundle() {
        MyLottoBundle myLottoBundle = new MyLottoBundle(
                LottoFactory.createLotto(1, new FixedLottoNumber()));

        List<Lotto> lottoBundle = myLottoBundle.getMyLottoBundle();
        Lotto lotto = lottoBundle.get(0);

        assertEquals(1, lotto.get(0));
        assertEquals(2, lotto.get(1));
        assertEquals(3, lotto.get(2));
        assertEquals(4, lotto.get(3));
        assertEquals(5, lotto.get(4));
        assertEquals(6, lotto.get(5));
    }
}
