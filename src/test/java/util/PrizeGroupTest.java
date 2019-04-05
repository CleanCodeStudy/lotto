package util;

import domain.LottoMachine.LottoMachine;
import domain.LottoTicket;
import domain.WinningLotto;
import domain.bundle.LottoBundle;
import dto.BuyLottoTicketDto;
import dto.InputDto;
import dto.ManualNumberDto;
import dto.WinningInputDto;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeGroupTest {

    /*
    Arrays.asList(1, 2, 3, 4, 5, 6);
    Arrays.asList(1, 2, 3, 4, 5, 7);
    Arrays.asList(1, 2, 3, 4, 5, 45);
     */

    @Test
    public void 우승로또와_비교해서_로또순위_반환확인() {
        int price = 3000;
        int manualAmount = 3;
        int bonus = 7;
        List<Integer> winningnumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningInputDto winningInputDto = new WinningInputDto(winningnumbers,bonus);
        WinningLotto winningLotto = new WinningLotto(winningInputDto);

        ManualNumberDto manualNumberDto1 = new ManualNumberDto(Arrays.asList(1, 2, 3, 4, 5, 6));    //1등
        ManualNumberDto manualNumberDto2 = new ManualNumberDto(Arrays.asList(1, 2, 3, 4, 5, 7));    //2등
        ManualNumberDto manualNumberDto3 = new ManualNumberDto(Arrays.asList(1, 2, 3, 4, 5, 45));   //3등

        List<ManualNumberDto> manualNumberDtos =
                Arrays.asList(manualNumberDto1,
                        manualNumberDto2,
                        manualNumberDto3);

        InputDto inputDto = new InputDto(price, manualAmount, manualNumberDtos);


        //when
        LottoMachine random = new LottoMachine(inputDto);
        BuyLottoTicketDto buyLottoTicketDto = random.buyLotto();

        LottoBundle lottoBundle = new LottoBundle(buyLottoTicketDto);

        LottoTicket ticket1 = lottoBundle.getTickets().get(0);
        LottoTicket ticket2 = lottoBundle.getTickets().get(1);
        LottoTicket ticket3 = lottoBundle.getTickets().get(2);


        assertThat(PrizeGroup.findRankByCountOfMatchAndBonus(ticket1, winningLotto)).isEqualByComparingTo(PrizeGroup.FIRST);
        assertThat(PrizeGroup.findRankByCountOfMatchAndBonus(ticket2, winningLotto)).isEqualByComparingTo(PrizeGroup.SECOND);
        assertThat(PrizeGroup.findRankByCountOfMatchAndBonus(ticket3, winningLotto)).isEqualByComparingTo(PrizeGroup.THIRD);


    }

}