package com.javabom.lotto.domain;

import com.javabom.lotto.domain.ticket.LottoTicket;
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

    @DisplayName("입력한 수동 로또 번호가 6개가 아니면 IllegalArgumentException을 발생시킨다.")
    @Test
    void checkCount() {
        List<List<String>> manualLottoNumbers = new ArrayList<>();
        List<String> manualLottoNumber = Arrays.asList("1", "2", "3", "4", "5");
        manualLottoNumbers.add(manualLottoNumber);

        assertThatThrownBy(() -> new Customer(1000, manualLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%d개의 수동 로또 번호를 입력하셨습니다. 수동 로또 번호는 총 6개여야 합니다.", manualLottoNumber.size()));
    }

    @DisplayName("수동으로 구입한 로또 번호가 중복될 시 IllegalArgumentException을 발생시킨다.")
    @Test
    void checkDuplicate() {
        List<List<String>> manualLottoNumbers = new ArrayList<>();
        List<String> manualLottoNumber = Arrays.asList("1", "2", "3", "4", "5", "5");
        manualLottoNumbers.add(manualLottoNumber);

        assertThatThrownBy(() -> new Customer(1000, manualLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("수동 로또 번호는 모두 달라야 합니다.");
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
}
