package com.vehicledekho;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {

    public static String url = "jdbc:mysql://localhost:3306/vehicledatabase";
    public static String username = "root";
    public static String password = "Aym@n2523";
    public static Vehicle tempVehicle = null;

    public static List<Vehicle> getFromDatabase() throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `vehicledatabase`.`vehicle3`");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String vehicleBrand = resultSet.getString("vehicleBrand");
                String vehicleName = resultSet.getString("vehicleName");
                int maxSpeed = resultSet.getInt("maxSpeed");
                int price = resultSet.getInt("price");
                vehicles.add(new Vehicle(id, vehicleBrand, vehicleName, maxSpeed, price));
            }
            con.close();
        } catch (Exception e) {
        }
        return vehicles;
    }

    public static void toDatabase(List<Vehicle> vehicles) {

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement statement = con.createStatement();
            for (Vehicle vehicle : vehicles) {
                String Query = String.format(
                        "INSERT INTO `vehicledatabase`.`vehicle3` (`id`, `vehicleBrand`, `vehicleName`, `maxSpeed`,`price`) VALUES (%d, '%s', '%s', %d, %d)",
                        vehicle.getId(), vehicle.getVehicleBrand(), vehicle.getVehicleName(), vehicle.getMaxSpeed(),
                        vehicle.getPrice());
                statement.executeUpdate(Query);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}