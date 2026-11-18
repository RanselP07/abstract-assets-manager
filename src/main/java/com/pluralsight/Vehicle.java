package com.pluralsight;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Vehicle extends Asset{
    String makeModel;
    int year;
    int odometer;

    public Vehicle(String description, String dateAcquired, BigDecimal originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public BigDecimal getValue() {
        int currentYear = LocalDate.now().getYear();
        int carYear = currentYear - year;
        BigDecimal carValue = originalCost;
        BigDecimal reduction;

        String[] car = makeModel.split(" ");
        String carMake = car[0];

        if (carYear < 0){
            System.out.print("\nYou mean you have a new car, from this year -");
            carYear = 0;
        }

        if (carYear <= 3){
            reduction = carValue.multiply(BigDecimal.valueOf(.03).multiply(BigDecimal.valueOf(carYear)));
            carValue = carValue.subtract(reduction);
        } else if (carYear <= 6){
            reduction = carValue.multiply(BigDecimal.valueOf(.06).multiply(BigDecimal.valueOf(carYear)));
            carValue = carValue.subtract(reduction);
        } else if (carYear <= 10){
            reduction = carValue.multiply(BigDecimal.valueOf(.08).multiply(BigDecimal.valueOf(carYear)));
            carValue = carValue.subtract(reduction);
        } else {
            carValue = carValue.subtract(BigDecimal.valueOf(1000.00));
        }

        if (odometer > 100_000 && !carMake.equalsIgnoreCase("Honda") || !carMake.equalsIgnoreCase("Toyota")){
            reduction = carValue.multiply(BigDecimal.valueOf(.25));
            carValue = carValue.subtract(reduction);
        }

        return carValue;
    }

}
