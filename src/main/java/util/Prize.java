package util;

public class Prize {

    private int price;

    public Prize(int price) {
        this.price = price;
    }

    public int getPrize(int amount) {
        return price * amount;
    }

}
