package view;

import domain.LottoList;
import domain.RandomLottoList;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static Scanner scanner;

    public InputView(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public String inputString() {
        return scanner.nextLine();
    }

    public LottoList getLottoList() {
        System.out.println(
                "로또 1장의 가격은 1000원이다.\n" +
                        "구입금액을 입력해 주세요.\n");
        int price = Integer.parseInt(inputString());

        LottoList lottoList = new RandomLottoList(price);

        new ResultView().showBuyedList(lottoList);

        return lottoList;
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String winningNumberLine = inputString();

        String[] winStringArr = winningNumberLine
                .replace(" ", "")
                .split(",");

        return Arrays.stream(winStringArr)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
