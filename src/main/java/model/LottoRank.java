package model;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    OUT(0,0),
    SECOND_BONUS(-1, 30000000);

    private int correctRank;
    private int price;

    LottoRank(int correctRank, int price) {
        this.correctRank = correctRank;
        this.price = price;
    }

//    public static LottoRank findByCorrectRank(int correctAmount) {
//        return Arrays.stream(LottoRank.values())
//                .filter(rank -> rank.getCorrectRank() == correctAmount)
//                .findAny()
//                .orElse(OUT);
//    }

    public int getCorrectRank() {
        return correctRank;
    }

    public int getPrice() {
        return price;
    }

}
