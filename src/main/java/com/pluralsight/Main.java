package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

    static void main(String[] args) {
        ArrayList<Asset> assets = new ArrayList<>();
        int i = 0;

        House house= new House("primary home!", "3/7/25", BigDecimal.valueOf(150000.00), "123 Main St", 1, 2200, 6000);
        assets.add(house);

        house = new House("vacation home!", "7/17/17", BigDecimal.valueOf(175000.00), "345 Main St", 2, 1400, 10000);
        assets.add(house);

        Vehicle vehicle = new Vehicle("Family vehicle", "5/14/24", BigDecimal.valueOf(67000.00), "Honda Pilot", 2024, 38455);
        assets.add(vehicle);

        vehicle = new Vehicle("Sport vehicle", "5/14/26", BigDecimal.valueOf(175000.00), "McLaren P1", 2026, 3787);
        assets.add(vehicle);

        for (Asset a : assets){
            String message = a.toString();

            if (assets.get(i) instanceof House houseAsset){
                message += "\nAddress: " + houseAsset.getAddress();
            }else if (assets.get(i) instanceof Vehicle vehicleAsset){
                message += "\nmake/model: " + vehicleAsset.getMakeModel();
            }

            System.out.print("\n" + message + "\n");
            i++;
        }
    }

}
