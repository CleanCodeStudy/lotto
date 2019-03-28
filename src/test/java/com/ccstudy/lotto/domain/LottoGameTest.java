package com.ccstudy.lotto.domain;

import org.junit.Test;
import com.ccstudy.lotto.util.FixedGeneratorImpl;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    @Test
    public void 로또_3개_생성_테스트() {
        LottoGame lottoGame = new LottoGame(3000, new ArrayList<Lotto>(), new FixedGeneratorImpl(0));

        List<Lotto> fixedLottos = getFixedLottos(3);

        for(int i = 0 ; i < lottoGame.getLottos().size() ; i++){
            assertThat(lottoGame.getLottos().get(i).getNumbers()).isEqualTo(fixedLottos.get(i).getNumbers());
        }

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