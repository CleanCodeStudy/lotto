package com.ccstudy.lotto.domain;

import org.junit.Test;
import com.ccstudy.lotto.util.FixedListGeneratorImpl;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    @Test
    public void 로또_3개_생성_테스트() {
        LottoGame lottoGame = new LottoGame(3000,new FixedListGeneratorImpl(0));

        List<Lotto> fixedLottoList = new ArrayList<>();
        FixedListGeneratorImpl fixedListGenerator = new FixedListGeneratorImpl(0);

        for (int i=0; i<3; i++){
            Lotto myLotto = new Lotto(fixedListGenerator.getSixList());
            fixedLottoList.add(myLotto);
        }

        for(int i = 0 ; i < lottoGame.getLottos().size() ; i++){
            assertThat(lottoGame.getLottos().get(i).getNumbers()).isEqualTo(fixedLottoList.get(i).getNumbers());
        }

    }
}