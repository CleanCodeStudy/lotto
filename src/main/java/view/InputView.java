package view;

import dto.PurchaseInfoDto;
import dto.WinningNumberDto;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static PurchaseInfoDto enterPurchaseInfo(InputStream inputStream) {
        System.out.println("구입금액을 입력해 주세요.");
        int money = createScanner(inputStream).nextInt();
        System.out.println("수동으로 몇개 구입할지 입력하세요.");
        int amount = createScanner(inputStream).nextInt();
        List<String> numbers = inputLottoNumbers(inputStream, amount);
        return new PurchaseInfoDto(money, amount, numbers);
    }


    public static WinningNumberDto inputWinningNumber(InputStream inputStream) {
        System.out.println("당첨볼 입력");
        String numbers = createScanner(inputStream).nextLine();
        System.out.println("보너스 볼을 입력해주세요.");
        String bonus = createScanner(inputStream).nextLine();
        return new WinningNumberDto(numbers,bonus);
    }


    public static List<String> inputLottoNumbers(InputStream inputStream, int manualLottoAmount) {
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
