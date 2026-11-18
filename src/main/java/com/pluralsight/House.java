package com.pluralsight;

import java.math.BigDecimal;

public class House extends Asset{
    String address;
    int condition;
    int squareFoot;
    int lotSize;

    public House(String description, String dateAcquired, BigDecimal originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    @Override
    public BigDecimal getValue() {
        BigDecimal houseValue = originalCost;

        switch (condition){
            case 1 -> {houseValue = houseValue.add(BigDecimal.valueOf(180.00).multiply(BigDecimal.valueOf(squareFoot)));}
            case 2 -> {houseValue = houseValue.add(BigDecimal.valueOf(130.00).multiply(BigDecimal.valueOf(squareFoot)));}
            case 3 -> {houseValue = houseValue.add(BigDecimal.valueOf(90.00).multiply(BigDecimal.valueOf(squareFoot)));}
            case 4 -> {houseValue = houseValue.add(BigDecimal.valueOf(80.00).multiply(BigDecimal.valueOf(squareFoot)));}
            default -> {throw new RuntimeException("That is not a condition. pick a number between 1-4.");}
        }

//        if (condition == 1){
//            houseValue = houseValue.add(BigDecimal.valueOf(180.00 * squareFoot));
//        } else if (condition == 2) {
//            houseValue = houseValue.add(BigDecimal.valueOf(130.00 * squareFoot));
//        } else if (condition == 3) {
//            houseValue = houseValue.add(BigDecimal.valueOf(90.00 * squareFoot));
//        } else if (condition == 4) {
//            houseValue = houseValue.add(BigDecimal.valueOf(80.00 * squareFoot));
//        } else {
//            System.out.println("That is not a condition.");
//        }

        houseValue = houseValue.add(BigDecimal.valueOf(.25 * lotSize));

        return houseValue;
    }

}
