package domain;

import java.util.Arrays;

public enum Rank {
    일등(2_000_000_000, 6),
    이등(1_500_000, 5),
    삼등(50_000, 5),
    사등(5_000, 4),
    꽝(0, -1);

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

    public boolean isWin(long correctAmount) {
        return this.amount == correctAmount;
    }

    public static Rank valueOf(boolean correctBonusBall, long correctAmount) {
        if(Rank.이등.isWin(correctAmount)){
            return correctBonusBall ? Rank.이등 : Rank.삼등;
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isWin(correctAmount))
                .findFirst()
                .orElse(Rank.꽝);
    }
}
