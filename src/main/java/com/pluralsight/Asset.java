package com.pluralsight;

import java.math.BigDecimal;

public class Asset {
    String description;
    String dateAcquired;
    BigDecimal originalCost;

    public Asset(String description, String dateAcquired, BigDecimal originalCost) {
        this.description = description;
        this.dateAcquired = dateAcquired;
        this.originalCost = originalCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(String dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public BigDecimal getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(BigDecimal originalCost) {
        this.originalCost = originalCost;
    }

    public BigDecimal getValue(){
        return originalCost;
    }

    @Override
    public String toString() {
        String format = "Description: %s\nDate: %s\nOriginal Price: $%.2f\nCurrent value: $%.2f";
        return String.format(format, this.description, this.dateAcquired, this.originalCost, getValue());
    }
}
