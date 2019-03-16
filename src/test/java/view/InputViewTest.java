package view;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class InputViewTest {

    @Test
    public void 구입_금액_입력() {
        String purchase = "6000";
        InputStream purchaseInputStream = new ByteArrayInputStream(purchase.getBytes());
        InputView inputView = new InputView(purchaseInputStream);
        assertEquals(6000, inputView.purchase());
    }
}