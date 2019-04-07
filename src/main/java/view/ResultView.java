package view;

import domain.LottoTicket;
import domain.Rank;
import dto.WinningResultDto;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    public static void printMyLottos(List<LottoTicket> lottoTickets) {
        lottoTickets.forEach(System.out::println);
    }

    public static void printResults(WinningResultDto winningResultDto) {
        Arrays.stream(Rank.values()).forEach(rank ->printResult(rank, winningResultDto));
        System.out.println(String.format("총 수익률은 %2.1f입니다.", winningResultDto.getYield()));
    }

    private static void printResult(Rank rank, WinningResultDto result) {
        if(Rank.꽝 !=rank) {
            System.out.println(String.format("%d개 일치 (%d원) - %d개", rank.getAmount(), rank.getPrice(), result.getResults(rank)));
        }
    }
}
