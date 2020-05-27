package com.javabom.lotto.view;

import com.javabom.lotto.domain.dto.BonusNumberDto;
import com.javabom.lotto.domain.dto.UserMoneyDto;
import com.javabom.lotto.domain.dto.WinningTicketDto;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static UserMoneyDto askInputMoney() {
        System.out.println("투입금액을 입력해 주세요.");
        return new UserMoneyDto(SCANNER.nextLine());
    }

    public static WinningTicketDto askWinningTicket() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return new WinningTicketDto(SCANNER.nextLine());
    }

    public static BonusNumberDto askBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new BonusNumberDto(SCANNER.nextLine());
    }
}
