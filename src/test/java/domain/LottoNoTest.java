package domain;

import org.junit.Test;
import util.numberGenerator.FixedNumberGenerator;
import util.numberGenerator.NumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNoTest {

    @Test
    public void 숫자_하나_만들기() {
        int number = 4;
        LottoNo lottoNo = new LottoNo(number);

        assertThat(lottoNo.getNumber()).isEqualTo(4);
    }

    @Test
    public void 숫자_6개_만들기() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6);
        NumberGenerator numberGenerator = new FixedNumberGenerator(input);
        List<LottoNo> LottoNumbers =
                numberGenerator.createLottoNumbers();

        assertThat(LottoNumbers.size()).isEqualTo(6);
        assertThat(LottoNumbers.stream()
                .map(LottoNo::getNumber)
                .collect(Collectors.toList()))
                .contains(1, 2, 3, 4, 5, 6);

    }

}