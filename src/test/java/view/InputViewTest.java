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
        int price = InputView.purchaseLotto(inputStream);
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
        assertThat(winningNumbers).contains("1","2","3","4","5","6");
    }
}