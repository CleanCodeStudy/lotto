package dto;

import java.util.List;

public class InputDto {
    private int price;
    private int manualAmount;
    private List<ManualNumberDto> manualNumberDtos;

    public InputDto(int price, int manualAmount, List<ManualNumberDto> manualNumberDtos) {
        this.price = price;
        this.manualAmount = manualAmount;
        this.manualNumberDtos = manualNumberDtos;
    }

    public int getPrice() {
        return price;
    }

    public int getManualAmount() {
        return manualAmount;
    }


    public List<ManualNumberDto> getManualNumberDtos() {
        return manualNumberDtos;
    }
}
