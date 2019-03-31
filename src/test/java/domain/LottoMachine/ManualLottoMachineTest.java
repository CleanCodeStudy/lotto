package domain.LottoMachine;

import dto.InputDto;
import dto.ManualNumberDto;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualLottoMachineTest {

    @Test
    public void 수동로또_한장_사기() {
        //given
        int price = 1000;
        int amount = 1;
        ManualNumberDto manualNumberDto = new ManualNumberDto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<ManualNumberDto> manualNumberDtos = Arrays.asList(manualNumberDto);
        InputDto inputDto = new InputDto(price,amount,manualNumberDtos);
        LottoMachine lottoMachine = new ManualLottoMachine(inputDto);

        //when
        int lottoAmount = lottoMachine.buyLotto().size();

        //then
        assertThat(lottoAmount).isEqualTo(1);
    }

}