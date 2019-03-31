package domain.LottoMachine;

import dto.InputDto;
import dto.ManualNumberDto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLottoMachineTest {

    @Test
    public void 랜덤로또로_1장_사기() {
        //given
        int price = 1000;
        int amount = 0;
        ManualNumberDto manualNumberDto = new ManualNumberDto(new ArrayList<>());
        List<ManualNumberDto> manualNumberDtos = Arrays.asList(manualNumberDto);
        InputDto inputDto = new InputDto(price, amount, manualNumberDtos);
        LottoMachine lottoMachine = new RandomLottoMachine(inputDto);

        //when
        int lottoAmount = lottoMachine.buyLotto().size();

        //then
        assertThat(lottoAmount).isEqualTo(1);
    }
}