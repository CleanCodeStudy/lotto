package com.ccstudy.lotto.domain;

import com.ccstudy.lotto.util.FixedGeneratorImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    public void 총_획득금액_테스트(){
        List<Lotto> lottos = getFixedLottos(3);

        LottoResult lottoResult = new LottoResult(lottos, Arrays.asList(5,6,7,8,9,10));

        assertThat(lottoResult.getReceivedAmount()).isEqualTo(55000);
    }

    @Test
    public void 총_수익률_테스트(){
        List<Lotto> lottos = getFixedLottos(3);

        LottoResult lottoResult = new LottoResult(lottos, Arrays.asList(5,6,7,8,9,10));

        assertThat(lottoResult.getYield()).isEqualTo(1833.33);
    }

    public List<Lotto> getFixedLottos(int amoutOfLotto) {
        List<Lotto> fixedLottos = new ArrayList<>();
        FixedGeneratorImpl fixedListGenerator = new FixedGeneratorImpl(0);

        for (int i = 0; i < amoutOfLotto; i++) {
            Lotto myLotto = new Lotto(fixedListGenerator.getSixList());
            fixedLottos.add(myLotto);
        }

        return fixedLottos;
    }

}