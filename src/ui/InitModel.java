package ui;

import java.util.ArrayList;

import model.*;

/**
 * Class to test the model.
 */
public class InitModel {
    
    /**
     * Method to create some vehicles.
     * @return The list of vehicles.
     */
    public ArrayList<Vehicle> initVehicles(){
            
            ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

            //selling price must be $604000 and the gasoline consumption must be  5 * (125/75) = 8.3333
            Document [] dV1 = {null, new TechnoMechanical(0, 2024, 0), null};
            Vehicle v1 = new Motorcycle(VehicleType.NEW, 100000, "Susuki", 2014, 125, 12000, null, dV1, MotorcycleType.CROSS, 5);
            vehicles.add(v1);

            //selling price must be 6800000 and the gasoline consumption must be  10 * (1000/150) = 66.66
            Document [] dV2 = {new SOAT(250000, 2022, 323323), new TechnoMechanical(130000, 2021, 545445), new PropertyCard(90000, 2013)};
            Vehicle v2 = new GasolineCar(VehicleType.USED, 200000, "Ford", 2013, 1000, 190000, "ABC123", dV2, CarType.SEDAN, 4, false, GasolineType.DIESEL, 10);
            vehicles.add(v2);

            //selling price must be $1100000 and the battery consumption must be  (100 + 13) * (900/100) = 1017
            Document [] dV3 = {null, new TechnoMechanical(0, 2024, 0), null};
            Vehicle v3 = new ElectricCar(VehicleType.NEW, 500000, "Tesla", 2020, 900, 1200, null, dV3, CarType.SEDAN, 4, true, ChargerType.FAST, 100);
            vehicles.add(v3);

            //selling price must be $1050000, the gasoline consumption must be  7 * (1100/180) = 42.777 and the battery consumption must be  (14 + 7) * (1100/200) = 115.5
            Document [] dV4 = {new SOAT(13223, 2022, 323223), new TechnoMechanical(140000, 2022, 131313), new PropertyCard( 100000, 2020)};
            Vehicle v4 = new HybridCar(VehicleType.USED, 1000000, "Toyota", 2011, 1100, 2000, "DFG456", dV4, CarType.SUV, 1, false, GasolineType.EXTRA, 7, ChargerType.NORMAL, 14);
            vehicles.add(v4);

            return vehicles;

        }   
    


    
}
