package com.javabom.lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String NOTICE_INPUT_MONEY = "구입 금액을 입력해 주세요. 잔돈은 없습니다 ^^";

    private static final Scanner scanner = new Scanner(System.in);

    public static int getBuyTicketQuantity() {
        System.out.println(NOTICE_INPUT_MONEY);
        int input = scanner.nextInt();
        return input / 1000;
    }
}
