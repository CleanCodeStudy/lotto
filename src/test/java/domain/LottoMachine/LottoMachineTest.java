package domain.LottoMachine;

import domain.bundle.LottoBundle;
import dto.InputDto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    public void 랜덤로또로_1장_사기() {
        //given
        int price = 1000;
        int amount = 0;
        InputDto inputDto = new InputDto(price, amount, new ArrayList<>());
        LottoMachine lottoMachine = new LottoMachine(inputDto);

        //when
        LottoBundle lottoBundle = lottoMachine.buyLottoTicket();
        int manualAmount = lottoBundle.getManualAmount();
        int randomAmount = lottoBundle.getRandomAmount();
        int lottoAmount = manualAmount + randomAmount;

        //then
        assertThat(lottoAmount).isEqualTo(1);
    }

    @Test
    public void 수동로또_1장_사기() {
        //given
        int price = 1000;
        int amount = 1;
        InputDto inputDto = new InputDto(price, amount, Arrays.asList("1,2,3,4,5,6"));
        LottoMachine lottoMachine = new LottoMachine(inputDto);

        //when
        LottoBundle lottoBundle = lottoMachine.buyLottoTicket();
        int manualAmount = lottoBundle.getManualAmount();
        int randomAmount = lottoBundle.getRandomAmount();
        int lottoAmount = manualAmount + randomAmount;

        //then
        assertThat(lottoAmount).isEqualTo(1);
        assertThat(lottoBundle.getTickets().get(0).getNumbers()).contains(1, 2, 3, 4, 5, 6);
    }
}