import controller.LottoController;
import domain.LottoList;
import org.junit.Test;
import view.InputView;

import java.io.ByteArrayInputStream;
import java.util.List;

public class LottoControllerTest {

    @Test
    public void 로또사고_추첨하기() {
        InputView inputView = new InputView(new ByteArrayInputStream("14000".getBytes()));
        LottoList lottoList = inputView.getLottoList();

        inputView = new InputView(new ByteArrayInputStream("1, 2, 3, 4, 5, 6".getBytes()));
        List<Integer> winningNumbers = inputView.getWinningNumbers();

        LottoController lottoController = new LottoController();
        System.out.println(lottoController.lotto(lottoList, winningNumbers));
    }

}