package com.javabom.lotto.view;

import com.javabom.lotto.domain.compare.LottoBasicLuckyNumbers;
import com.javabom.lotto.domain.compare.LottoLuckyNumbers;
import com.javabom.lotto.domain.ticket.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String NOTICE_INPUT_MONEY = "구입 금액을 입력해 주세요. 잔돈은 없습니다 ^^";
    private static final String NOTICE_INPUT_BASIC_LUCKY_NUMBER = "지난 주 당첨 번호를 입력해 주세요. (,로 나눠서 입력)";
    private static final String NOTICE_INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static long getMoneyToBuyTicket() {
        printLineOf(NOTICE_INPUT_MONEY);
        return Long.parseLong(scanner.nextLine());
    }

    public static LottoLuckyNumbers getLottoLuckyNumbers() {
        LottoBasicLuckyNumbers basicLuckyNumbers = getLottoBasicLuckyNumbers();
        LottoNumber bonusNumber = getBonusNumber();
        return new LottoLuckyNumbers(basicLuckyNumbers, bonusNumber);
    }

    private static LottoBasicLuckyNumbers getLottoBasicLuckyNumbers() {
        printLineOf(NOTICE_INPUT_BASIC_LUCKY_NUMBER);
        List<LottoNumber> numbers = Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new LottoBasicLuckyNumbers(numbers);
    }

    private static LottoNumber getBonusNumber() {
        printLineOf(NOTICE_INPUT_BONUS_NUMBER);
        return new LottoNumber(scanner.nextInt());
    }

    private static void printLineOf(String string) {
        System.out.println(string);
    }

}
