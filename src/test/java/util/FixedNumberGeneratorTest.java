package util;

import domain.LottoNo;
import org.junit.Test;
import util.numberGenerator.FixedNumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class FixedNumberGeneratorTest {

    @Test
    public void 고정숫자_생성하기() {
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<LottoNo> lottoNumbers = fixedNumberGenerator.createLottoNumbers();
        //사이즈검사
        assertThat(lottoNumbers.size()).isEqualTo(6);
        //고정숫자 생성되었는지 확인
        assertThat(lottoNumbers.stream()
                .map(LottoNo::getNumber)
                .collect(Collectors.toList())).contains(1, 2, 3, 4, 5, 6);
    }

}