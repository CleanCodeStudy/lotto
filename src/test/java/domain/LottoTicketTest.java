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
        LottoTicket lottoTicket = new LottoTicket(numbers);

        assertThat(lottoTicket.getNumbers()).contains(1, 2, 3, 4, 5, 6);
    }


    @Test
    public void 번호_몇개_일치하는지_확인() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoTicket lottoTicket = new LottoTicket(numbers);
        
        WinningLotto winningLotto = new WinningInputDto("4,5,6,7,8,9","45").toWinningLotto();

        int matchAmount = lottoTicket.getCountOfMatch(winningLotto);
        assertThat(matchAmount).isEqualTo(3);

    }


    @Test
    public void 보너스_번호_가지고있는지_확인하기() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        LottoTicket lottoTicket = new LottoTicket(numbers);


        String bonus = "3";
        String winningnumbers = "11,12,13,14,15,16";
        WinningInputDto winningInputDto = new WinningInputDto(winningnumbers, bonus);
        WinningLotto winningLotto = winningInputDto.toWinningLotto();

        assertThat(lottoTicket.hasBonus(winningLotto)).isTrue();

        bonus = "45";
        winningnumbers = "1,2,3,4,5,6";
        winningInputDto = new WinningInputDto(winningnumbers, bonus);
        winningLotto = winningInputDto.toWinningLotto();

        assertThat(lottoTicket.hasBonus(winningLotto)).isFalse();

    }

    @Test
    public void 랜덤인지_수동인지_체크하기(){
        LottoTicket mTicket = new LottoTicket(Arrays.asList(1,2,3,4,5,6),LottoTicket.MANUAL);
        LottoTicket rTicket = new LottoTicket(Arrays.asList(1,2,3,4,5,6));

        assertThat(mTicket.isRandom()).isFalse();
        assertThat(rTicket.isRandom()).isTrue();
    }
}