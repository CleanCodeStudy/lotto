package util;

import java.util.Arrays;

public enum PrizeGroup {

    THREE(3, new Prize(5000), "3개 일치 (5000원)"),
    FOUR(4, new Prize(50000), "4개 일치 (50000원)"),
    FIVE(5, new Prize(1500000), "5개 일치 (150000원)"),
    SIX(6, new Prize(2000000000), "6개 일치 (2000000000원)"),
    DEFAULT(0, new Prize(0), "");

    private int match;
    private Prize prize;
    private String comment;

    PrizeGroup(int match, Prize prize, String comment) {
        this.match = match;
        this.prize = prize;
        this.comment = comment;
    }

    public static Prize findPrize(final int key) {
        return Arrays.stream(PrizeGroup.values())
                .filter(prizeGroup -> prizeGroup.hasKey(key))
                .findFirst()
                .orElse(PrizeGroup.DEFAULT)
                .prize;
    }

    private boolean hasKey(final int key) {
        return this.match == key;
    }

    public Prize getPrize() {
        return this.prize;
    }

    public String getComment() {
        return this.comment;
    }

    public int getMatch() {
        return this.match;
    }
}
