package view;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String SPLITTER = ",";

    public static int inputPurchasePrice(InputStream inputStream) {
        System.out.println("구입금액을 입력해 주세요.");
        return createScanner(inputStream).nextInt();
    }

    public static int inputManualAmount(InputStream inputStream) {
        System.out.println("수동으로 몇개 구입할지 입력하세요.");
        return createScanner(inputStream).nextInt();
    }

    public static List<String> inputWinningNumber(InputStream inputStream) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] numbers = createScanner(inputStream).nextLine()
                .replace(" ", "")
                .split(SPLITTER);

        return Arrays.asList(numbers);
    }


    public static List<String> inputLottoNumbers(InputStream inputStream,int manualLottoAmount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<String> manualNumbers = new ArrayList<>();
        for (int i = 0; i < manualLottoAmount; i++) {
            manualNumbers.add(createScanner(inputStream).nextLine());
        }

        return manualNumbers;
    }

    private static Scanner createScanner(InputStream inputStream) {
        return new Scanner(inputStream);
    }
}
