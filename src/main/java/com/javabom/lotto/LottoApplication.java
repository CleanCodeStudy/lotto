package com.javabom.lotto;

import com.javabom.lotto.domain.Customer;
import com.javabom.lotto.domain.shop.AutoLottoNumberGenerator;
import com.javabom.lotto.domain.shop.LottoShop;
import com.javabom.lotto.domain.shop.LottoMachine;
import com.javabom.lotto.domain.number.PrizeNumbersBundle;
import com.javabom.lotto.domain.result.LottoResultBundle;
import com.javabom.lotto.domain.ticket.LottoTicketBundle;
import com.javabom.lotto.view.InputView;
import com.javabom.lotto.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class LottoApplication {
    private static final InputView inputView = new InputView(new Scanner(System.in));

    public static void main(String[] args) {

        int amount = inputView.inputMoney();
        int manualLottoTicketCount = inputView.inputManualLottoTicketCount();
        List<List<String>> manualLottoNumbers = inputView.inputManualLottoNumbers(manualLottoTicketCount);
        Customer customer = new Customer(amount, manualLottoNumbers);

        LottoShop lottoShop = new LottoShop(new LottoMachine(new AutoLottoNumberGenerator()));
        LottoTicketBundle lottoTicketBundle = lottoShop.buy(customer);

        OutputView.printLottoCount(manualLottoNumbers.size(), customer.getAutoLottoTicketCount());
        OutputView.printLottoBundle(lottoTicketBundle);

        PrizeNumbersBundle prizeNumberBundle = new PrizeNumbersBundle(
                inputView.inputPrizeNumbers(), inputView.inputBonusNumber());

        LottoResultBundle lottoResultBundle = lottoTicketBundle.getLottoResults(prizeNumberBundle);

        OutputView.printResults(lottoResultBundle, amount);
    }
}
