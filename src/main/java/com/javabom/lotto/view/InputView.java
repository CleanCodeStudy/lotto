package com.javabom.lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String askTotalPrice() {
        System.out.println("구입금액을 입력해주세요.");
        return SCANNER.next();
    }

    public static String askLastWeekLottoNumber() {
        System.out.println("지난주 당첨 번호를 입력해주세요");
        return SCANNER.next();
    }

    public static String askLastWeekBonusNumber() {
        System.out.println("보너스번호를 입력해주세요");
        return SCANNER.next();
    }
}
