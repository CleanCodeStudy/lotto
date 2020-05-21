package com.javabom.lotto.domain.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SortedLottoNumbersFactoryTest {

    @DisplayName("LottoNumber의 size가 45인지 확인")
    @Test
    void create() {
        // given
        List<LottoNumber> lottoNumbers = SortedLottoNumbersFactory.create();

        // then
        assertThat(lottoNumbers.size()).isEqualTo(45);
    }
    // 얘는 어떻게 테스트를 하면 좋을지 몰라서 (for문을 쓰는 것은 지양하라 하여서)
    // size 로 대체했으나, 정렬된것은 어떻게 테스트를 해야하는지 모르겠습니다 (for문없이)
}