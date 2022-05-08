package model;

import java.util.ArrayList;
import java.time.LocalDate;

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
     * @param pcPrice price of property card. Null if the motorcycle is new
     * @param pcYear year of property card. Null if the motorcycle is new
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
    public boolean registerVehicle(int vehicleType, double basePrice, String brand, String model, int cylinderCapacity, double mileage, String licensePlate, Double pcPrice, int pcYear, Double tmPrice, Integer tmYear, Double gasEmitted, Double soatPrice, Integer soatYear, Double coverageAmount, int motorcycleType, double gasolineCapacity, double gasolineConsumption) {

        Document documents[] = registerDocuments(vehicleType, pcPrice, pcYear, tmPrice, tmYear, gasEmitted, soatPrice, soatYear, coverageAmount);
        VehicleType type = (vehicleType == 1) 
                            ? VehicleType.NEW 
                            : VehicleType.USED;

        
        MotorcycleType mType  = null;                    
        switch (motorcycleType) {
			case 1:
				mType = MotorcycleType.STANDAR;
				break;
			case 2:
				mType = MotorcycleType.SPORT;
				break;
			case 3:
				mType = MotorcycleType.SCOOTER;
				break;
			case 4:
				mType = MotorcycleType.CROSS;
				break;

		}

        Vehicle motorcycle = new Motorcycle(type, basePrice,brand, model, cylinderCapacity, mileage, licensePlate, documents, mType, gasolineCapacity, gasolineConsumption);

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
     * @param pcPrice price of property card. Null if the car is new
     * @param pcYear year of property card. Null if the car is new
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

    public boolean registerVehicle(int vehicleType, double basePrice, String brand, String model, int cylinderCapacity, double mileage, String licensePlate, Double pcPrice, Integer pcYear, Double tmPrice, Integer tmYear, Double gasEmitted, Double soatPrice, Integer soatYear, Double coverageAmount, int carType, int doorsNumber, int hasTintedWindows, int gasolineType, double tankCapacity, double gasolineConsumption) {

        Document documents[] = registerDocuments(vehicleType, pcPrice, pcYear, tmPrice, tmYear, gasEmitted, soatPrice, soatYear, coverageAmount);
        VehicleType type = (vehicleType == 1) 
                            ? VehicleType.NEW 
                            : VehicleType.USED;

        CarType cType = (carType == 1)
                            ? CarType.SEDAN
                            :CarType.SUV;

        GasolineType gType = null;

        switch (gasolineType) {
            case 1:
                gType = GasolineType.EXTRA;
                break;
            case 2:
                gType = GasolineType.DIESEL;
                break;
            case 3:
                gType = GasolineType.REGULAR;
        }


        Vehicle gasolineCar = new GasolineCar(type, basePrice, brand, model, cylinderCapacity, mileage, licensePlate, documents, cType, doorsNumber, (hasTintedWindows == 1)? true: false, gType, tankCapacity, gasolineConsumption);

        return vehicles.add(gasolineCar);

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
     * @param pcPrice price of property card. Null if the car is new
     * @param pcYear year of property card. Null if the car is new
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

    public boolean registerVehicle(int vehicleType, double basePrice, String brand, String model, int cylinderCapacity, double mileage, String licensePlate, Double pcPrice, Integer pcYear, Double tmPrice, Integer tmYear, Double gasEmitted, Double soatPrice, Integer soatYear, Double coverageAmount, int carType, int doorsNumber, int hasTintedWindows, int chargerType, int batteryLife, double batteryConsumption) {

        Document documents[] = registerDocuments(vehicleType, pcPrice, pcYear, tmPrice, tmYear, gasEmitted, soatPrice, soatYear, coverageAmount);
        VehicleType type = (vehicleType == 1) 
                            ? VehicleType.NEW 
                            : VehicleType.USED;

        CarType cType = (carType == 1)
                            ? CarType.SEDAN
                            : CarType.SUV;


        ChargerType charger = (chargerType == 1)
                            ? ChargerType.FAST
                            : ChargerType.NORMAL;
        
        Vehicle electricCar = new ElectricCar(type, basePrice, brand, model, cylinderCapacity, mileage, licensePlate, documents, cType, doorsNumber, (hasTintedWindows == 1)? true: false, charger, batteryLife, batteryConsumption);
    
        return vehicles.add(electricCar);

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
     * @param pcPrice price of property card. Null if the car is new
     * @param pcYear year of property card. Null if the car is new
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

    public boolean registerVehicle(int vehicleType, double basePrice, String brand, String model, int cylinderCapacity, double mileage, String licensePlate, Double pcPrice, Integer pcYear, Double tmPrice, Integer tmYear, Double gasEmitted, Double soatPrice, Integer soatYear, Double coverageAmount, int carType, int doorsNumber, int hasTintedWindows, int gasolineType, double tankCapacity, double gasolineConsumption, int chargerType, int batteryLife, double batteryConsumption) {

        Document documents[] = registerDocuments(vehicleType, pcPrice, pcYear, tmPrice, tmYear, gasEmitted, soatPrice, soatYear, coverageAmount);
        VehicleType type = (vehicleType == 1) 
                            ? VehicleType.NEW 
                            : VehicleType.USED;

        CarType cType = (carType == 1)
                            ? CarType.SEDAN
                            :CarType.SUV;

        GasolineType gType = null;
        switch (gasolineType) {
            case 1:
                gType = GasolineType.EXTRA;
                break;
            case 2:
                gType = GasolineType.DIESEL;
                break;
            case 3:
                gType = GasolineType.REGULAR;
        }

        ChargerType charger = (chargerType == 1)
                            ? ChargerType.FAST
                            : ChargerType.NORMAL;

        Vehicle hybridCar = new HybridCar(type, basePrice, brand, model, cylinderCapacity, mileage, licensePlate, documents, cType, doorsNumber, (hasTintedWindows == 1)? true : false, gType, tankCapacity, gasolineConsumption, charger, batteryLife, batteryConsumption);

        return vehicles.add(hybridCar);
    }

    /**
     * Method to configure the documents of the vehicle
     * @param vehicleType the type of vehicle. New or used
     * @param pcPrice price of property card. Null if the vehicle is new
     * @param pcYear year of property card. Null if the vehicle is new
     * @param tmPrice price of the techno mechanical document. Null if the vehicle is new.
     * @param tmYear year of the techno mechanical document. Null if the vehicle is new.
     * @param gasEmitted gas emitted by the vehicle. Null if the vehicle is new.
     * @param soatPrice price of the SOAT document. Null if the vehicle has no SOAT.
     * @param soatYear year of the SOAT document. Null if the vehicle has no SOAT.
     * @param coverageAmount amount of coverage of the SOAT document. Null if the vehicle has no SOAT.
     * @return the documents of the vehicle
     */

    public Document[] registerDocuments(int vehicleType, Double pcPrice, Integer pcYear, Double tmPrice, Integer tmYear, Double gasEmitted, Double soatPrice, Integer soatYear, Double coverageAmount) {
        
        Document documents[] = new Document[3];

        //If the vehicle is new, it hasn't SOAT and property card. The techno mechanical document is new.
        if(vehicleType == 1) {
            //SOAT
            documents[0] = null;
            //Techno mechanical
            documents[1] = new TechnoMechanical(0, LocalDate.now().getYear(), 0);
            //Property card
            documents[2] = null;

        }else {
            //If the vehicle is used, it has techno mechanical and property card. The vehicle may or may not have SOAT.
            
            if(soatPrice != null) {
                documents[0] = new SOAT(soatPrice, soatYear, coverageAmount);
            }else {
                documents[0] = null;
            }
            //Techno mechanical
            documents[1] = new TechnoMechanical(tmPrice, tmYear, gasEmitted);
            //Property card
            documents[2] = new PropertyCard(pcPrice, pcYear);
        }

        return documents;

    }

    public String generateReport(int option) {
        String report = "";

        switch (option) {
            case 1:
                report = generateReportByType();
                break;
            case 2:
                report = generateReportByFuel();
                break;
            case 3:
                report = generateReportByUse();
                break;

        }   

        return report;
    }
    
    public String generateReportByType() {
        String reportMotorcycle = "Motorcycles: \n", reportGasolineCar = "Gas Cars: \n", reportElectricCar = "Electric cars: \n", reportHybridCar = "Hybrid cars: \n";

        for(int i = 0; i < vehicles.size(); i++) {
            if(vehicles.get(i) instanceof Motorcycle) {
                reportMotorcycle += ((Motorcycle)vehicles.get(i)).toString() + "\n";
            }else if(vehicles.get(i) instanceof GasolineCar) {
                reportGasolineCar += ((GasolineCar)vehicles.get(i)).toString() + "\n";
            }else if(vehicles.get(i) instanceof ElectricCar) {
                reportElectricCar += ((ElectricCar)vehicles.get(i)).toString() + "\n";
            }else if(vehicles.get(i) instanceof HybridCar) {
                reportHybridCar +=  ((HybridCar)vehicles.get(i)).toString() + "\n";
            }
        }

        return reportMotorcycle + reportGasolineCar + reportElectricCar + reportHybridCar;
            
    }

    public String generateReportByFuel() {
        String reportGasoline = "", reportElectric = "", reportHybrid = "";
        return reportGasoline + reportElectric + reportHybrid;
    }

    public String generateReportByUse() {
        String reportNew = "", reportUsed = "";

        for(int i = 0; i < vehicles.size(); i++) {
            if(vehicles.get(i).getType() == VehicleType.NEW) {
                reportNew += vehicles.get(i).toString() + "\n";
            }else {
                reportUsed += vehicles.get(i).toString() + "\n";
            }
        }

        return reportNew + reportUsed;
    }


}




