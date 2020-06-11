package com.javabom.lotto.domain;

import com.javabom.lotto.domain.number.GameNumber;
import com.javabom.lotto.domain.number.PrizeNumbersBundle;
import com.javabom.lotto.domain.result.LottoResult;
import com.javabom.lotto.domain.result.LottoResultBundle;
import com.javabom.lotto.domain.shop.FIxedNumberGenerator;
import com.javabom.lotto.domain.shop.LottoMachine;
import com.javabom.lotto.domain.shop.LottoShop;
import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.ticket.LottoTicketBundle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomerTest {

    @DisplayName("입력한 돈의 값이 0원보다 작으면 IllegalArgumentExceptiion을 발생시킨다.")
    @Test
    void checkPositive() {
        List<List<String>> manualLottoNumbers = new ArrayList<>();
        int amount = -1;
        assertThatThrownBy(() -> new Customer(amount, manualLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%d, 0원 이상의 돈을 입력해 주세요.", amount));
    }

    @DisplayName("보유하고 있는 금액이 수동티켓 구입 금액보다 부족하면 IllegalArgumentExceptiion을 발생시킨다.")
    @Test
    void checkBuyManualLottoTicket() {
        List<List<String>> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(Arrays.asList("1", "2", "3", "4", "5", "6"));
        manualLottoNumbers.add(Arrays.asList("1", "2", "3", "4", "5", "6"));

        int amount = 1500;
        int requiredAmount = manualLottoNumbers.size() * LottoTicket.PRICE;
        assertThatThrownBy(() -> new Customer(amount, manualLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("현재 보유 금액:%d, 필요한 금액:%d, 금액이 부족합니다.", amount, requiredAmount));
    }

    @DisplayName("구입할 수 있는 자동 로또 티켓 갯수를 반환한다.")
    @ParameterizedTest
    @CsvSource({"10000,8", "4500,2"})
    void getAutoLottoTicketCount(int amount, int expected) {
        List<List<String>> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(Arrays.asList("1", "2", "3", "4", "5", "6"));
        manualLottoNumbers.add(Arrays.asList("1", "2", "3", "4", "5", "6"));

        Customer customer = new Customer(amount, manualLottoNumbers);
        assertThat(customer.getAutoLottoTicketCount()).isEqualTo(expected);
    }

    @DisplayName("구입한 로또 티켓이 잘 들어왔는지 확인한다.")
    @Test
    void buy() {
        List<List<String>> manualLottoNumbers = new ArrayList<>();

        Customer customer = new Customer(1000, manualLottoNumbers);

        LottoShop lottoShop = new LottoShop(new LottoMachine(new FIxedNumberGenerator()));

        lottoShop.enter(customer);
        LottoTicketBundle lottoTicketBundle = customer.getLottoTicketBundle();

        List<LottoTicket> lottoTickets = lottoTicketBundle.get();
        LottoTicket actual = lottoTickets.get(0);

        assertThat(actual.get(0)).isEqualTo(GameNumber.valueOf(1));
        assertThat(actual.get(1)).isEqualTo(GameNumber.valueOf(2));
        assertThat(actual.get(2)).isEqualTo(GameNumber.valueOf(3));
        assertThat(actual.get(3)).isEqualTo(GameNumber.valueOf(4));
        assertThat(actual.get(4)).isEqualTo(GameNumber.valueOf(5));
        assertThat(actual.get(5)).isEqualTo(GameNumber.valueOf(6));
    }

    @DisplayName("로또 결과를 잘 반환하는지 확인한다.")
    @Test
    void confirmLottoResult(){
        List<List<String>> manualLottoNumbers = new ArrayList<>();

        List<String> prizeNumbers = Arrays.asList("1", "2", "3", "4", "5", "8");
        PrizeNumbersBundle prizeNumberBundle = new PrizeNumbersBundle(prizeNumbers, "6");

        Customer customer = new Customer(1000, manualLottoNumbers);
        LottoMachine lottoMachine = new LottoMachine(new FIxedNumberGenerator());
        customer.buy(lottoMachine.createAutoLottoTicket(1));

        LottoResultBundle lottoResultBundle = customer.confirmLottoResult(prizeNumberBundle);

        assertThat(lottoResultBundle.valueOf(0)).isEqualTo(LottoResult.SECOND);
    }
}
