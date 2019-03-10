package dto;

import domain.Lotto;
import org.junit.Test;
import util.FixedNumberGenerator;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoDtoTest {

    @Test
    public void 로또_번호_비교() {
        //given
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator();
        Lotto lotto = new Lotto(fixedNumberGenerator);

        //when
        LottoDto lottoDto = new LottoDto(lotto,Arrays.asList(4,5,6,7,8,9));
        //then

        assertThat(lottoDto.getAmount()).isEqualTo(3);
    }
}