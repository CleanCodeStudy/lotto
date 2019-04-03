package view;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class InputViewTest {

    @Test
    public void 만사천원을_입력하면_숫자로반환() {
        //given
        InputStream inputStream = new ByteArrayInputStream("14000".getBytes());
        //when
        int price = InputView.inputPurchasePrice(inputStream);
        //then
        assertThat(price).isEqualTo(14000);

    }

    @Test
    public void 당첨번호를_입력() {
        //given
        InputStream inputStream = new ByteArrayInputStream("1, 2, 3, 4, 5, 6".getBytes());
        //when
        List<String> winningNumbers = InputView.inputWinningNumber(inputStream);
        //then
        assertThat(winningNumbers).contains("1", "2", "3", "4", "5", "6");
    }

    @Test
    public void 수동_로또를_3장_구입한다() {
        //given
        InputStream inputStream = new ByteArrayInputStream("3".getBytes());
        //when
        int manualLottoAmount = InputView.inputManualAmount(inputStream);
        //then
        assertThat(manualLottoAmount).isEqualTo(3);
    }


    @Test
    public void 두장의_수동로또_번호를_입력한다() {
        //given
        String lottoNumbers = "1, 2, 3, 4, 5, 6\n"+"2, 3, 4, 5, 6,7\n";
        InputStream inputStream = new ByteArrayInputStream(lottoNumbers.getBytes());
        //when
        List<String> manualNumbers = InputView.inputLottoNumbers(inputStream,2);
        //then
        assertThat(manualNumbers.get(0)).contains("1","2","3","4","5","6");
        assertThat(manualNumbers.get(1)).contains("2","3","4","5","6","7");
    }


}