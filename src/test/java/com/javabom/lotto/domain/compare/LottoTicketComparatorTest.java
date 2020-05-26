package com.javabom.lotto.domain.compare;

import com.javabom.lotto.domain.ticket.LottoNumber;
import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.ticket.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.javabom.lotto.domain.compare.LottoResult.FIRST_PRIZE;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketComparatorTest {

    @DisplayName("로또 번호 1등 당첨일 때 테스트")
    @Test
    void getLottoResults() {
        // given
        List<Integer> lottoIntegerNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<LottoNumber> stubLottoNumbers = lottoIntegerNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        LottoNumber bonusNumber = new LottoNumber(7);
        LottoBasicLuckyNumbers basicLuckyNumbers = new LottoBasicLuckyNumbers(lottoIntegerNumbers);

        LottoLuckyNumbers lottoLuckyNumbers = new LottoLuckyNumbers(basicLuckyNumbers, bonusNumber);
        LottoTicketComparator lottoTicketComparator = new LottoTicketComparator(lottoLuckyNumbers);

        // when
        LottoTickets allMatchLottoTicket = new LottoTickets(Arrays.asList(new LottoTicket(stubLottoNumbers)));
        LottoResults lottoResults = lottoTicketComparator.getLottoResults(allMatchLottoTicket);
        LottoResults expectedLottoResults = new LottoResults(Arrays.asList(FIRST_PRIZE));

        // then
        assertThat(lottoResults).isEqualTo(expectedLottoResults);
    }
    // 여기서 각 등수별 테스트를 하려고 했는데 파라미터가 매우 많아지는 현상이 생깁니다.
    // 이 클래스를 잘못짰기 때문에 테스트가 힘든구조가 되는걸까요?
    // 여기서 테스트를 어떤식으로 해야할지 잘 모르겠습니다.
}