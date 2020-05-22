package com.javabom.lotto.view;

import java.util.Scanner;

public class InputView {

    public static String askInputMoney() {
        System.out.println("투입금액을 입력해 주세요.");
        return new Scanner(System.in).nextLine();
    }

    public static String askWinningNumber() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return new Scanner(System.in).nextLine();
    }

    public static String askBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new Scanner(System.in).nextLine();
    }
}
