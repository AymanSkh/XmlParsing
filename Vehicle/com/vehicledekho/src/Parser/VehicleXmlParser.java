package com.vehicledekho;

import java.io.File;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class VehicleXmlParser {

    public static List<Vehicle> getVehicle() {

        try {
            File file = new File("src\\com\\vehicledekho\\vehicle.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Vehicles.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Vehicles vehicles = (Vehicles) unmarshaller.unmarshal(file);
            List<Vehicle> vehicleList = vehicles.getVehicles();
            return vehicleList;
        } catch (JAXBException e) {

        }

        return null;

    }

}
