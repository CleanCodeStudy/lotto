package util;

import domain.Lotto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    public void 로또_하나_만들기() {
        //given
        //when
        //then
        assertThat(LottoGenerator.createLotto().size()).isEqualTo(6);
    }
}