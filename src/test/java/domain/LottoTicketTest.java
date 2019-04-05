package domain;

import dto.WinningInputDto;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    public void 로또생성() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<LottoNo> lottoNos = numbers.stream()
                .map(integer -> new LottoNo(integer))
                .collect(Collectors.toList());
        LottoTicket lottoTicket = new LottoTicket(lottoNos);

        assertThat(lottoTicket.getNumbers()).contains(1, 2, 3, 4, 5, 6);
    }


    @Test
    public void 번호_몇개_일치하는지_확인() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<LottoNo> lottoNos = numbers.stream()
                .map(integer -> new LottoNo(integer))
                .collect(Collectors.toList());
        LottoTicket lottoTicket = new LottoTicket(lottoNos);

        List<Integer> winningNumbers = Arrays.asList(4, 5, 6, 7, 8, 9);

        int matchAmount = lottoTicket.getCountOfMatch(winningNumbers);
        assertThat(matchAmount).isEqualTo(3);

    }


    @Test
    public void 보너스_번호_가지고있는지_확인하기() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<LottoNo> lottoNos = numbers.stream()
                .map(integer -> new LottoNo(integer))
                .collect(Collectors.toList());
        LottoTicket lottoTicket = new LottoTicket(lottoNos);


        int bonus = 3;

        WinningInputDto winningInputDto = new WinningInputDto(Arrays.asList(11, 12, 13, 14, 15, 16), bonus);
        WinningLotto winningLotto = new WinningLotto(winningInputDto);
        assertThat(lottoTicket.hasBonus(winningLotto)).isTrue();

        bonus = 45;
        winningInputDto = new WinningInputDto(Arrays.asList(11, 12, 13, 14, 15, 16), bonus);

        winningLotto = new WinningLotto(winningInputDto);
        assertThat(lottoTicket.hasBonus(winningLotto)).isFalse();

    }
}