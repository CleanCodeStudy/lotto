package com.javabom.lotto.view;

import com.javabom.lotto.domain.dto.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static MoneyDto askInputMoney() {
        System.out.println("투입금액을 입력해 주세요.");
        return new MoneyDto(SCANNER.nextLine());
    }

    public static WinningNumbersDto askWinningTicket() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return new WinningNumbersDto(SCANNER.nextLine());
    }

    public static BonusNumberDto askBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new BonusNumberDto(SCANNER.nextLine());
    }

    public static ManualLottoNumbersDto askManualLottoNumbers(int count) {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoNumbers.add(SCANNER.nextLine());
        }

        return new ManualLottoNumbersDto(lottoNumbers);
    }

    public static ManualLottoCountDto askManualNumberCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return new ManualLottoCountDto(SCANNER.nextLine());
    }
}
