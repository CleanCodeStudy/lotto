package com.javabom.lotto.view;

import com.javabom.lotto.dto.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static final String DELIMITER = ",";

    public static InputDto askInputMoneyAndManual() {
        InputDto inputDto = new InputDto(getMoney(), getManualCount());
        inputDto.setManualNumbers(getManualLottoNumbers(inputDto.getManualCount()));

        return inputDto;
    }

    public static List<List<String>> getManualLottoNumbers(int count) {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<List<String>> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoNumbers.add(Arrays.asList(SCANNER.nextLine().split(DELIMITER)));
        }

        return lottoNumbers;
    }

    private static String getManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    private static String getMoney() {
        System.out.println("투입금액을 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static WinningNumbersDto askWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return new WinningNumbersDto(getWinningNumbers(), getBonusNumber());
    }

    private static List<String> getWinningNumbers() {
        return Arrays.asList(SCANNER.nextLine().split(DELIMITER));
    }

    private static String getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextLine();
    }

}
