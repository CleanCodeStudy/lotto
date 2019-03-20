package com.ccstudy.lotto.domain;

import com.ccstudy.lotto.util.FixedListGeneratorImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    public void 총_획득금액_테스트(){
        FixedListGeneratorImpl fixedListGenerator = new FixedListGeneratorImpl(0);
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0 ; i < 3 ;i++){
            lottos.add(new Lotto(fixedListGenerator.getSixList()));
        }

        LottoResult lottoResult = new LottoResult(lottos, Arrays.asList(5,6,7,8,9,10));

        assertThat(lottoResult.getReceivedAmount()).isEqualTo(55000);
    }

    @Test
    public void 총_수익률_테스트(){
        FixedListGeneratorImpl fixedListGenerator = new FixedListGeneratorImpl(0);
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0 ; i < 3 ;i++){
            lottos.add(new Lotto(fixedListGenerator.getSixList()));
        }

        LottoResult lottoResult = new LottoResult(lottos, Arrays.asList(5,6,7,8,9,10));

        assertThat(lottoResult.getYield()).isEqualTo(1833.33);
    }

}