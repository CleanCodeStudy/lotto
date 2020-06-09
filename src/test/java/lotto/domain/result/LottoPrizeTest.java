package lotto.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {

    @DisplayName("번호일치 갯수에 따른 LottoPrize를 반환한다")
    @CsvSource({"3,flase,FIFTH", "5, false,THIRD", "5,true,SECOND",
            "6, false, FIRST", "2, false, MISS"})
    @ParameterizedTest
    void findLottoPrize(int matchCount, boolean matchBonus, LottoPrize expectedLottoPrize) {
        //when
        LottoPrize byMathCount = LottoPrize.findByMathCount(matchCount, matchBonus);

        //then
        assertThat(byMathCount).isEqualTo(expectedLottoPrize);
    }

}
