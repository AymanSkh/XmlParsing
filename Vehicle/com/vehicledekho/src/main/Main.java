package com.vehicledekho;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        List<Vehicle> vehicles = VehicleXmlParser.getVehicle();
        DatabaseManager.toDatabase(vehicles);
        List<Vehicle> vehicleList = DatabaseManager.getFromDatabase();
        for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle.getVehicleName());

        }

    }

}
