package view;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static model.LottoGame.LOTTO_PRICE;

public class InputView {

    public static Scanner sc;

    public InputView(InputStream inputStream) {
        sc = new Scanner(inputStream);
    }

    public int purchase() {
        System.out.println("로또 1장의 가격은 " + LOTTO_PRICE + "원 이다.\n" +
                "구입금액을 입력해 주세요.");
        return sc.nextInt();
    }

    public List<Integer> inputWinNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winNumberString = sc.next();
        return makeWinNumberList(winNumberString);
    }

    private List<Integer> makeWinNumberList(String winNumberString) {
        return Arrays.asList(winNumberString.split(","))
                .stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
