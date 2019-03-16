package view;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String SPLITTER = ",";

    public static int purchaseLotto(InputStream inputStream) {
        System.out.println("구입금액을 입력해 주세요.");
        return createScanner(inputStream).nextInt();
    }

    public static List<String> inputWinningNumber(InputStream inputStream) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] numbers = createScanner(inputStream).nextLine()
                .replace(" ", "")
                .split(SPLITTER);

        return Arrays.stream(numbers)
                .collect(Collectors.toList());
    }

    private static Scanner createScanner(InputStream inputStream) {
        return new Scanner(inputStream);
    }


}
