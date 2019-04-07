package dto;

import java.util.List;

public class InputDto {
    private int price;
    private int manualAmount;
    private List<String> manuals;

    public InputDto(int price, int manualAmount, List<String> manuals) {
        this.price = price;
        this.manualAmount = manualAmount;
        this.manuals = manuals;
    }

    public int getPrice() {
        return price;
    }

    public int getManualAmount() {
        return manualAmount;
    }

    public List<String> getManuals() {
        return manuals;
    }
}
