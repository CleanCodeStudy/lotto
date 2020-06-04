package com.javabom.lotto.view;

import com.javabom.lotto.domain.ticket.ManualLottoNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String DELIMITER_COMMA = ",";
    private static final String NOTICE_INPUT_MONEY = "구입 금액을 입력해 주세요. 잔돈은 없습니다 ^^";
    private static final String NOTICE_INPUT_BASIC_LUCKY_NUMBER = "지난 주 당첨 번호를 입력해 주세요. (,로 나눠서 입력)";
    private static final String NOTICE_INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String NOTICE_INPUT_MANUAL_LOTTO_AMOUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String NOTICE_INPUT_MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static int getMoneyToBuyTicket() {
        printLineOf(NOTICE_INPUT_MONEY);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> getLottoBasicLuckyNumbers() {
        printLineOf(NOTICE_INPUT_BASIC_LUCKY_NUMBER);
        return Arrays.stream(scanner.nextLine().split(DELIMITER_COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int getBonusNumber() {
        printLineOf(NOTICE_INPUT_BONUS_NUMBER);
        return scanner.nextInt();
    }

    public static int getManualLottoAmount() {
        printLineOf(NOTICE_INPUT_MANUAL_LOTTO_AMOUNT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<ManualLottoNumbers> getManualLottoNumbers(int amount) {
        printLineOf(NOTICE_INPUT_MANUAL_LOTTO_NUMBER);
        List<ManualLottoNumbers> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            manualLottoNumbers.add(new ManualLottoNumbers(getManualLottoNumber()));
        }
        return manualLottoNumbers;
    }

    public static List<Integer> getManualLottoNumber() {
        return Arrays.stream(scanner.nextLine().split(DELIMITER_COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void printLineOf(String string) {
        System.out.println(string);
    }

}
