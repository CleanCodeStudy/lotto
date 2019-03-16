package domain.result;

import java.util.List;

public enum Rank {
    일등(2000000000, 6),
    이등(1500000, 5),
    삼등(50000, 4),
    사등(5000, 3);

    private int price;

    private int amount;

    Rank(int price, int amount) {
        this.price = price;
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public long count(List<LottoResult> lottoResults) {
        return lottoResults.stream()
                .filter(lottoResult -> lottoResult.isEqualToAmount(this.amount))
                .count();
    }
}
