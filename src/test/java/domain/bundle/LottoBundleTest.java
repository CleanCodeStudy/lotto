package domain.bundle;

import domain.LottoMachine.LottoMachine;
import dto.InputDto;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBundleTest {


    @Test
    public void 수동갯수_자동갯수_카운트() {

        //given
        int price = 7000;
        int amount = 4;
        InputDto inputDto = new InputDto(price, amount, Arrays.asList("1,2,3,4,5,6", "1,2,3,4,5,6", "1,2,3,4,5,6", "1,2,3,4,5,6"));
        LottoMachine lottoMachine = new LottoMachine(inputDto);

        //when
        LottoBundle lottoBundle = lottoMachine.buyLottoTicket();

        assertThat(lottoBundle.getManualAmount()).isEqualTo(4);
        assertThat(lottoBundle.getRandomAmount()).isEqualTo(3);
    }

}