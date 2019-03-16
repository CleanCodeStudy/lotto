package view;

import java.io.InputStream;
import java.util.Scanner;

import static controller.LottoController.LOTTO_PRICE;

public class InputView {

    public static Scanner sc;

    public InputView(InputStream inputStream) {
        sc = new Scanner(inputStream);
    }

    public int purchase() {
        System.out.println("로또 1장의 가격은 "+LOTTO_PRICE+"원이다.\n" +
                "구입금액을 입력해 주세요.");
        return sc.nextInt();
    }

    public String winNumber(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return sc.next();
    }
}
