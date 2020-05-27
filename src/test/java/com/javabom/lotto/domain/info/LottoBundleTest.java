package com.javabom.lotto.domain.info;

import com.javabom.lotto.domain.info.Lotto;
import com.javabom.lotto.domain.info.LottoBundle;
import com.javabom.lotto.domain.info.PrizeNumberInfo;
import com.javabom.lotto.domain.result.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoBundleTest {

    @DisplayName("알맞은 로또 결과를 반환하는지 확인한다.")
    @Test
    public void confirmLottoResult() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 3, 5, 7, 9, 11));

        List<Lotto> lottoList = Arrays.asList(lotto1, lotto2);

        LottoBundle lottoBundle = new LottoBundle(lottoList);

        List<String> prizeNumbers = Arrays.asList("1", "2", "4", "7", "9", "11");
        PrizeNumberInfo prizeNumberInfo = new PrizeNumberInfo(prizeNumbers, "30");

        List<LottoResult> lottoResultBundle = lottoBundle.confirmLottoResult(prizeNumberInfo).get();
        assertThat(lottoResultBundle.size()).isEqualTo(2);
        assertTrue(lottoResultBundle.get(0).isEquals(3));
        assertTrue(lottoResultBundle.get(1).isEquals(4));
    }
}
