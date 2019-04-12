package model;

import data.PurchaseInfo;
import data.WinnigNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private static final int PERCENTAGE = 100;
    private List<LottoResultTicket> lottoResultTickets;

    public LottoResult(LottoMachine lottoMachine, WinnigNumber winnigNumber) {
        this.lottoResultTickets = createLottoResults(lottoMachine, winnigNumber);
    }

    private List<LottoResultTicket> createLottoResults(LottoMachine lottoMachine, WinnigNumber winnigNumber) {
        List<LottoResultTicket> resultTickets = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoMachine.getLottoTickets()) {
            resultTickets.add(new LottoResultTicket(lottoTicket, winnigNumber));
        }
        return resultTickets;
    }

    public float analyzeYield(PurchaseInfo purchaseInfo) {
        int beforePrice = purchaseInfo.getPurchasePrice();

        int nowPrice = lottoResultTickets.stream()
                .map(ticket -> ticket.getLottoRank().getPrice())
                .mapToInt(Integer::intValue)
                .sum();

        return yieldFormula(nowPrice, beforePrice);
    }

    private float yieldFormula(int nowPrice, int beforePrice) {
        return nowPrice / (float) beforePrice * PERCENTAGE;
    }

    public int getResultCount(LottoRank lottoRank) {
        int results = (int) lottoResultTickets.stream()
                .filter(x -> x.getLottoRank().equals(lottoRank))
                .count();
        return results;
    }

}
