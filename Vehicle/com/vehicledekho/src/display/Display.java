package com.vehicledekho;

import java.util.List;

public class Display {
    public static void printVehicleInfo(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println("Id: " + vehicle.getId());
            System.out.println("Brand: " + vehicle.getVehicleBrand());
            System.out.println("Name: " + vehicle.getVehicleName());
            System.out.println("MaxSpeed: " + vehicle.getMaxSpeed());
            System.out.println("Price: " + vehicle.getPrice());

            System.out.println("==========================");

        }

    }

}
