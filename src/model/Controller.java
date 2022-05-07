package model;

import java.util.ArrayList;
import java.util.Date;

public class Controller {

    private ArrayList <Vehicle> vehicles;
    
    public Controller() {
        
        vehicles = new ArrayList <Vehicle>();
        
    }


    /**
     * Method to register a motorcycle
     * @param vehicleType the type of vehicle. New or used
     * @param basePrice the base price of the motorcycle
     * @param brand the brand of the motorcycle
     * @param model the model of the motorcycle. 
     * @param cylinderCapacity the cylinder capacity of the motorcycle
     * @param mileage the mileage of the motorcycle. 0 if the motorcycle is new
     * @param licensePlate the license plate of the motorcycle. Null if the motorcycle is new
     * @param tmPrice price of the techno mechanical document. Null if the motorcycle is new.
     * @param tmYear year of the techno mechanical document. Null if the motorcycle is new.
     * @param gasEmitted gas emitted by the motorcycle. Null if the motorcycle is new.
     * @param soatPrice price of the SOAT document. Null if the motorcycle has no SOAT.
     * @param soatYear year of the SOAT document. Null if the motorcycle has no SOAT.
     * @param coverageAmount amount of coverage of the SOAT document. Null if the motorcycle has no SOAT.
     * @param motorcycleType the type of motorcycle
     * @param gasolineCapacity motorcycle's gasoline capacity
     * @param gasolineConsumption motorcycle's gasoline consumption. 0 if the motorcycle is new
     * @return whether the motorcycle was registered or not
     */
    public boolean registerVehicle(int vehicleType, double basePrice, String brand, String model, int cylinderCapacity, double mileage, String licensePlate, Double tmPrice, Integer tmYear, Double gasEmitted, Double soatPrice, Integer soatYear, Double coverageAmount, int motorcycleType, double gasolineCapacity, double gasolineConsumption) {

        Document documents[] = new Document[3];
        VehicleType type = null;

        if(vehicleType == 1) {
            //SOAT
            documents[0] = null;
            //Techno mechanical
            documents[1] = new TechnoMechanical(0, 2022, 0);
            //Property card
            documents[2] = null;
        }else {
            //SOAT
            documents[0] = new SOAT(soatPrice, soatYear, coverageAmount);
            //Techno mechanical
            documents[1] = new TechnoMechanical(tmPrice, tmYear, gasEmitted);
            //Property card
            documents[2] = null;
        }

        if(vehicleType == 1) {
            type = VehicleType.NEW;
        }else{
            type = VehicleType.USED;
        }


        Vehicle motorcycle = new Motorcycle(type, basePrice,brand, model, cylinderCapacity, mileage, licensePlate, documents, gasolineCapacity, gasolineConsumption);

        return vehicles.add(motorcycle);

    }
    
    /**
     * Method to register a gasoline car
     * @param vehicleType the type of vehicle. New or used
     * @param basePrice base price of the car
     * @param brand brand of the car
     * @param model model of the car
     * @param cylinderCapacity cylinder capacity of the car
     * @param mileage mileage of the car. 0 if the car is new
     * @param licensePlate license plate of the car. Null if the vehicle is new
     * @param tmPrice price of the techno mechanical document. Null if the vehicle is new.
     * @param tmYear year of the techno mechanical document. Null if the vehicle is new.
     * @param gasEmitted gas emitted by the car. Null if the vehicle is new.
     * @param soatPrice price of the SOAT document. Null if the vehicle has no SOAT.
     * @param soatYear year of the SOAT document. Null if the vehicle has no SOAT.
     * @param coverageAmount amount of coverage of the SOAT document. Null if the vehicle has no SOAT.
     * @param carType the type of car. Sedan or SUV
     * @param doorsNumber doors number of the car
     * @param hasTintedWindows whether the car has tinted windows or not
     * @param gasolineType the type of car gasoline. Extra, diesel or regular
     * @param tankCapacity tank capacity of the car.
     * @param gasolineConsumption gasoline consumption of the car. 0 if the car is new
     * @return whether the gasoline car was registered or not
     */

    public boolean registerVehicle(int vehicleType, double basePrice, String brand, String model, int cylinderCapacity, double mileage, String licensePlate, Double tmPrice, Integer tmYear, Double gasEmitted, Double soatPrice, Integer soatYear, Double coverageAmount, int carType, int doorsNumber, int hasTintedWindows, int gasolineType, double tankCapacity, double gasolineConsumption) {

        return false;
    }

    /**
     * Method to register a electric car
     * @param vehicleType the type of vehicle. New or used
     * @param basePrice base price of the car
     * @param brand brand of the car
     * @param model model of the car
     * @param cylinderCapacity cylinder capacity of the car
     * @param mileage mileage of the car. 0 if the car is new
     * @param licensePlate license plate of the car. Null if the vehicle is new
     * @param tmPrice price of the techno mechanical document. Null if the vehicle is new.
     * @param tmYear year of the techno mechanical document. Null if the vehicle is new.
     * @param gasEmitted gas emitted by the car. Null if the vehicle is new.
     * @param soatPrice price of the SOAT document. Null if the vehicle has no SOAT.
     * @param soatYear year of the SOAT document. Null if the vehicle has no SOAT.
     * @param coverageAmount amount of coverage of the SOAT document. Null if the vehicle has no SOAT.
     * @param carType the type of car. Sedan or SUV
     * @param doorsNumber doors number of the car
     * @param hasTintedWindows whether the car has tinted windows or not
     * @param chargerType the type of charger. Fast or normal
     * @param batteryLife battery life of the car
     * @param batteryConsumption battery consumption of the car. 0 if the car is new
     * @return whether the electric car was registered or not
     */

    public boolean registerVehicle(int vehicleType, double basePrice, String brand, String model, int cylinderCapacity, double mileage, String licensePlate, Double tmPrice, Integer tmYear, Double gasEmitted, Double soatPrice, Integer soatYear, Double coverageAmount, int carType, int doorsNumber, int hasTintedWindows, int chargerType, int batteryLife, double batteryConsumption) {

                return false;
    }

    /**
     * Method to register a hybrid car
     * @param vehicleType the type of vehicle. New or used
     * @param basePrice base price of the car
     * @param brand brand of the car
     * @param model model of the car
     * @param cylinderCapacity cylinder capacity of the car
     * @param mileage mileage of the car. 0 if the car is new
     * @param licensePlate license plate of the car. Null if the vehicle is new
     * @param tmPrice price of the techno mechanical document. Null if the vehicle is new.
     * @param tmYear year of the techno mechanical document. Null if the vehicle is new.
     * @param gasEmitted gas emitted by the car. Null if the vehicle is new.
     * @param soatPrice price of the SOAT document. Null if the vehicle has no SOAT.
     * @param soatYear year of the SOAT document. Null if the vehicle has no SOAT.
     * @param coverageAmount amount of coverage of the SOAT document. Null if the vehicle has no SOAT.
     * @param carType the type of car. Sedan or SUV
     * @param doorsNumber doors number of the car
     * @param hasTintedWindows whether the car has tinted windows or not
     * @param gasolineType the type of gasoline. Extra, diesel or regular
     * @param tankCapacity tank capacity of the car.
     * @param gasolineConsumption gasoline consumption of the car. 0 if the car is new
     * @param chargerType the type of charger. Fast or normal
     * @param batteryLife battery life of the car
     * @param batteryConsumption battery consumption of the car. 0 if the car is new
     * @return whether the hybrid car was registered or not
     */

    public boolean registerVehicle(int vehicleType, double basePrice, String brand, String model, int cylinderCapacity, double mileage, String licensePlate, Double tmPrice, Integer tmYear, Double gasEmitted, Double soatPrice, Integer soatYear, Double coverageAmount, int carType, int doorsNumber, int hasTintedWindows, int gasolineType, double tankCapacity, double gasolineConsumption, int chargerType, int batteryLife, double batteryConsumption) {

                return false;
    }

    

}




