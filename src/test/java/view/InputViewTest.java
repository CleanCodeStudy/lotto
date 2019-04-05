package view;

import dto.ManualNumberDto;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @Test
    public void 가격입력_테스트() {
        //given
        InputView inputView = new InputView(new ByteArrayInputStream("14000".getBytes()));

        //when
        int price = inputView.getPrice();

        //then
        assertThat(price).isEqualTo(14000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 기본가격보다_적은_입력_테스트() {
        //given
        InputView inputView = new InputView(new ByteArrayInputStream("0".getBytes()));

        //when, then
        int price = inputView.getPrice();
    }

    @Test(expected = IllegalArgumentException.class)
    public void 음수_입력_테스트() {
        //given
        InputView inputView = new InputView(new ByteArrayInputStream("-1000".getBytes()));

        //when, then
        int price = inputView.getPrice();
    }

    @Test
    public void 수동입력갯수_테스트() {
        //given
        InputView inputView = new InputView(new ByteArrayInputStream("1".getBytes()));

        //when
        int amount = inputView.getManualAmount();

        //then
        assertThat(amount).isEqualTo(1);
    }

    @Test
    public void 수동번호_입력_테스트() {
        //given
        InputView inputView = new InputView(new ByteArrayInputStream("1,2,3,4,5,6".getBytes()));
        int amount = 1;

        //when
        List<ManualNumberDto> manualLottoNumbers = inputView.getManualLottoNumbers(amount);

        //then
        assertThat(manualLottoNumbers.size()).isEqualTo(1);
        assertThat(manualLottoNumbers.get(0).getLottoNos().get(0).getNumber()).isEqualTo(1);
        assertThat(manualLottoNumbers.get(0).getLottoNos().get(1).getNumber()).isEqualTo(2);
        assertThat(manualLottoNumbers.get(0).getLottoNos().get(2).getNumber()).isEqualTo(3);
        assertThat(manualLottoNumbers.get(0).getLottoNos().get(3).getNumber()).isEqualTo(4);
        assertThat(manualLottoNumbers.get(0).getLottoNos().get(4).getNumber()).isEqualTo(5);
        assertThat(manualLottoNumbers.get(0).getLottoNos().get(5).getNumber()).isEqualTo(6);
    }

    @Test
    public void 우승번호_입력_테스트() {
        //given
        InputView inputView = new InputView(new ByteArrayInputStream("1,2,3,4,5,6".getBytes()));

        //when
        List<Integer> winningLotto = inputView.getWinningNumbers();

        //then
        assertThat(winningLotto).contains(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void 보너스번호_입력_테스트() {
        //given
        InputView inputView = new InputView(new ByteArrayInputStream("7".getBytes()));

        //when
        int bonus = inputView.getBonusNumber();

        //then
        assertThat(bonus).isEqualTo(7);
    }
}