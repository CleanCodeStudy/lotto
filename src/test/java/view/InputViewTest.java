package view;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class InputViewTest {

    @Test
    public void 구입_금액_입력() {
        String purchase = "6000";
        InputStream purchaseInputStream = new ByteArrayInputStream(purchase.getBytes());
        InputView inputView = new InputView(purchaseInputStream);
        assertEquals(6000, inputView.purchase());
    }

    @Test
    public void 당첨_번호_입력() {
        String inputCorrectString = "1,3,6,7,8,9";
        InputStream inputCorrectStringStream = new ByteArrayInputStream(inputCorrectString.getBytes());
        InputView inputView = new InputView(inputCorrectStringStream);
        assertThat(inputView.inputWinNumber(), contains(1, 3, 6, 7, 8, 9));
    }

    @Test
    public void 수동_로또_입력() {
        String inputCorrectString = "1,3,6,7,8,9\n2,3,4,5,6,7\n1,2,3,4,5,6";
        InputStream inputCorrectStringStream = new ByteArrayInputStream(inputCorrectString.getBytes());
        InputView inputView = new InputView(inputCorrectStringStream);
//        assertThat(inputView.inputManualLotto(3).get(0).getNumbers(), contains(1, 3, 6, 7, 8, 9));
        assertThat(inputView.inputManualLotto(3).get(2).getNumbers(), contains(1, 2, 3, 4, 5, 6));
    }
}