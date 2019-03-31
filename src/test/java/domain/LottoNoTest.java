package domain;

import org.junit.Test;

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
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<LottoNo> lottoNos = numbers.stream()
                .map(integer -> new LottoNo(integer))
                .collect(Collectors.toList());

        assertThat(lottoNos.size()).isEqualTo(6);
        assertThat(lottoNos.stream()
                .map(LottoNo::getNumber)
                .collect(Collectors.toList()))
                .contains(1, 2, 3, 4, 5, 6);

    }

}