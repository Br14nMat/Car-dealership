package model;

import java.util.ArrayList;
import java.time.LocalDate;

/**
 * The is the Controller class that communicates the view and model.
 */

public class Controller {


    /**
     * This collection contains the vehicles of the car dealership.
     */
    private ArrayList <Vehicle> vehicles;

    /**
     * Parking to store older vehicles.
     */
    private Parking parking;
    
    /**
     * This is the constructor of the Controller class.
     */
    public Controller() {
        
        vehicles = new ArrayList <Vehicle>();
        parking = new Parking();
        
    }

    /**
     * This is the constructor of the Controller class. It is used to test the program.
     */

    public Controller(ArrayList <Vehicle> vehicles) {

        this.vehicles = vehicles;
        parking = new Parking();
        moveToParking();
    }


    /**
     * Method to register a motorcycle.
     * @param vehicleType the type of vehicle. New or used.
     * @param basePrice the base price of the motorcycle.
     * @param brand the brand of the motorcycle.
     * @param model the model of the motorcycle. 
     * @param cylinderCapacity the cylinder capacity of the motorcycle.
     * @param mileage the mileage of the motorcycle. 0 if the motorcycle is new.
     * @param licensePlate the license plate of the motorcycle. Null if the motorcycle is new.
     * @param pcPrice price of property card. Null if the motorcycle is new.
     * @param pcYear year of property card. Null if the motorcycle is new.
     * @param tmPrice price of the techno mechanical document. Null if the motorcycle is new.
     * @param tmYear year of the techno mechanical document. Null if the motorcycle is new.
     * @param gasEmitted gas emitted by the motorcycle. Null if the motorcycle is new.
     * @param soatPrice price of the SOAT document. Null if the motorcycle is new.
     * @param soatYear year of the SOAT document. Null if the motorcycle is new.
     * @param coverageAmount amount of coverage of the SOAT document. Null if the motorcycle is new.
     * @param motorcycleType the type of motorcycle.
     * @param gasolineCapacity motorcycle's gasoline capacity
     * @return whether the motorcycle was registered or not.
     */
    public boolean registerVehicle(int vehicleType, double basePrice, String brand, int model, int cylinderCapacity, double mileage, String licensePlate, Double pcPrice, Integer pcYear, Double tmPrice, Integer tmYear, Double gasEmitted, Double soatPrice, Integer soatYear, Double coverageAmount, int motorcycleType, double gasolineCapacity) {

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

        Vehicle motorcycle = new Motorcycle(type, basePrice,brand, model, cylinderCapacity, mileage, licensePlate, documents, mType, gasolineCapacity);
        
        if(isOld(motorcycle))
            parking.add(motorcycle);

        return vehicles.add(motorcycle);

    }

    /**
     * Method to register a gasoline car.
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
     * @param soatPrice price of the SOAT document. Null if the vehicle is new.
     * @param soatYear year of the SOAT document. Null if the vehicle is new.
     * @param coverageAmount amount of coverage of the SOAT document. Null if the vehicle is new.
     * @param carType the type of car. Sedan or SUV
     * @param doorsNumber doors number of the car.
     * @param hasTintedWindows whether the car has tinted windows or not.
     * @param gasolineType the type of car gasoline. Extra, diesel or regular.
     * @param tankCapacity tank capacity of the car.
     * @return whether the gasoline car was registered or not
     */

    public boolean registerVehicle(int vehicleType, double basePrice, String brand, int model, int cylinderCapacity, double mileage, String licensePlate, Double pcPrice, Integer pcYear, Double tmPrice, Integer tmYear, Double gasEmitted, Double soatPrice, Integer soatYear, Double coverageAmount, int carType, int doorsNumber, int hasTintedWindows, int gasolineType, double tankCapacity) {

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


        Vehicle gasolineCar = new GasolineCar(type, basePrice, brand, model, cylinderCapacity, mileage, licensePlate, documents, cType, doorsNumber, (hasTintedWindows == 1)? true: false, gType, tankCapacity);

        if(isOld(gasolineCar))
            parking.add(gasolineCar);

        return vehicles.add(gasolineCar);

    }

    /**
     * Method to register a electric car.
     * @param vehicleType the type of vehicle. New or used
     * @param basePrice base price of the car.
     * @param brand brand of the car.
     * @param model model of the car.
     * @param cylinderCapacity cylinder capacity of the car.
     * @param mileage mileage of the car. 0 if the car is new.
     * @param licensePlate license plate of the car. Null if the vehicle is new.
     * @param pcPrice price of property card. Null if the car is new.
     * @param pcYear year of property card. Null if the car is new.
     * @param tmPrice price of the techno mechanical document. Null if the vehicle is new.
     * @param tmYear year of the techno mechanical document. Null if the vehicle is new.
     * @param gasEmitted gas emitted by the car. Null if the vehicle is new.
     * @param soatPrice price of the SOAT document. Null if the vehicle is new.
     * @param soatYear year of the SOAT document. Null if the vehicle is new.
     * @param coverageAmount amount of coverage of the SOAT document. Null if the vehicle is new.
     * @param carType the type of car. Sedan or SUV.
     * @param doorsNumber doors number of the car.
     * @param hasTintedWindows whether the car has tinted windows or not.
     * @param chargerType the type of charger. Fast or normal..
     * @param batteryLife battery life of the car.
     * @return whether the electric car was registered or not.
     */

    public boolean registerVehicle(int vehicleType, double basePrice, String brand, int model, int cylinderCapacity, double mileage, String licensePlate, Double pcPrice, Integer pcYear, Double tmPrice, Integer tmYear, Double gasEmitted, Double soatPrice, Integer soatYear, Double coverageAmount, int carType, int doorsNumber, int hasTintedWindows, int chargerType, int batteryLife) {

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
        
        Vehicle electricCar = new ElectricCar(type, basePrice, brand, model, cylinderCapacity, mileage, licensePlate, documents, cType, doorsNumber, (hasTintedWindows == 1)? true: false, charger, batteryLife);
        
        if(isOld(electricCar))
            parking.add(electricCar);

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
     * @param soatPrice price of the SOAT document. Null if the vehis new.
     * @param soatYear year of the SOAT document. Null if the vehis new.
     * @param coverageAmount amount of coverage of the SOAT document. Null if the vehis new.
     * @param carType the type of car. Sedan or SUV
     * @param doorsNumber doors number of the car
     * @param hasTintedWindows whether the car has tinted windows or not
     * @param gasolineType the type of gasoline. Extra, diesel or regular
     * @param tankCapacity tank capacity of the car.
     * @param chargerType the type of charger. Fast or normal
     * @param batteryLife battery life of the car
     * @return whether the hybrid car was registered or not
     */

    public boolean registerVehicle(int vehicleType, double basePrice, String brand, int model, int cylinderCapacity, double mileage, String licensePlate, Double pcPrice, Integer pcYear, Double tmPrice, Integer tmYear, Double gasEmitted, Double soatPrice, Integer soatYear, Double coverageAmount, int carType, int doorsNumber, int hasTintedWindows, int gasolineType, double tankCapacity, int chargerType, int batteryLife) {

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

        Vehicle hybridCar = new HybridCar(type, basePrice, brand, model, cylinderCapacity, mileage, licensePlate, documents, cType, doorsNumber, (hasTintedWindows == 1)? true : false, gType, tankCapacity, charger, batteryLife);

        if(isOld(hybridCar))
            parking.add(hybridCar);

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
     * @param soatPrice price of the SOAT document. Null if the vehicle is new.
     * @param soatYear year of the SOAT document. Null if the vehicle is new.
     * @param coverageAmount amount of coverage of the SOAT document. Null if the vehicle is new.
     * @return the documents of the vehicle
     */

    public Document[] registerDocuments(int vehicleType, Double pcPrice, Integer pcYear, Double tmPrice, Integer tmYear, Double gasEmitted, Double soatPrice, Integer soatYear, Double coverageAmount) {
        
        Document documents[] = new Document[3];

        //If the vehicle is new, it hasn't SOAT and property card. The techno mechanical document is new.
        if(vehicleType == 1) {
            //SOAT
            documents[0] = null;
            //Techno mechanical
            documents[1] = new TechnoMechanical(0, (LocalDate.now().getYear() + 2), 0);
            //Property card
            documents[2] = null;

        }else {

            //If the vehicle is used, it has techno SOAT, mechanical and property card.
            documents[0] = new SOAT(soatPrice, soatYear, coverageAmount);
            //Techno mechanical
            documents[1] = new TechnoMechanical(tmPrice, tmYear, gasEmitted);
            //Property card
            documents[2] = new PropertyCard(pcPrice, pcYear);
        }

        return documents;

    }

    /**
     * Method to calculate the selling price of a vehicle. It returns -1 if the vehicle is not registered.
     */

    public double calculateSellingPrice(String id){

        Vehicle vehicle = findVehicle(id);
        double sellingPrice = -1;

        if(vehicle != null)
            sellingPrice = vehicle.calculateSellingPrice();

        return sellingPrice;
        
    }

    /**
     * Method to generate reports with all vehicles data. The report can be by type, fuel type or use.
     * @param option the option to generate the report. 1 for type, 2 for fuel type and 3 for use.
     * @return the report.
     */

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
                report = generateReportByUsage();
                break;

        }     

        return report;
    }

    /**
     * Method to generate a report by type. The types are: Motorcycle, GasolineCar, ElectricCar, HybridCar. 
     * @return the report by type.
     */
    
    public String generateReportByType() {
        String reportMotorcycle = "Motorcycles: \n \n", reportGasolineCar = "Gas Cars: \n \n", reportElectricCar = "Electric cars: \n \n", reportHybridCar = "Hybrid cars: \n \n";

        for(int i = 0; i < vehicles.size(); i++) {
            if(vehicles.get(i) instanceof Motorcycle) {
                reportMotorcycle += vehicles.get(i).toString() + "\n";
            }else if(vehicles.get(i) instanceof GasolineCar) {
                reportGasolineCar += vehicles.get(i).toString() + "\n";
            }else if(vehicles.get(i) instanceof ElectricCar) {
                reportElectricCar += vehicles.get(i).toString() + "\n";
            }else if(vehicles.get(i) instanceof HybridCar) {
                reportHybridCar += vehicles.get(i).toString() + "\n";
            }
        }
        
        return reportMotorcycle + reportGasolineCar + reportElectricCar + reportHybridCar;
            
    }


    /**
     * Method to generate a report by fuel type. The fuel types are: Extra, Diesel and Regular.
     * @return the report by fuel type.
    */

    public String generateReportByFuel() {

        String reportExtra = "Extra: \n \n", reportDiesel = "Diesel: \n \n", reportRegular = "Regular: \n \n";

        for(int i = 0; i < vehicles.size(); i++){

            if(vehicles.get(i) instanceof GasolineCar){

                switch (((GasolineCar) vehicles.get(i)).getGasolineType()) {
                    case EXTRA:
                        reportExtra += vehicles.get(i).toString() + "\n";
                        break;
                    case DIESEL:
                        reportDiesel += vehicles.get(i).toString() + "\n";
                        break;
                    case REGULAR:
                        reportRegular += vehicles.get(i).toString() + "\n";
                        break;
                }

            }

            if(vehicles.get(i) instanceof HybridCar){
                
                switch (((HybridCar) vehicles.get(i)).getGasolineType()) {
                    case EXTRA:
                        reportExtra += vehicles.get(i).toString() + "\n";
                        break;
                    case DIESEL:
                        reportDiesel += vehicles.get(i).toString() + "\n";
                        break;
                    case REGULAR:
                        reportRegular += vehicles.get(i).toString() + "\n";
                        break;

                }   

            }

        }

        return reportExtra + reportDiesel + reportRegular;
        
    }

    /**
     * Method to generate a report by usage. The report contains information on new and used cars..
     * @return the report by usage.
     */

    public String generateReportByUsage() {
        String reportNew = "New cars: \n \n", reportUsed = "Used cars: \n \n";

        for(int i = 0; i < vehicles.size(); i++) {

            if(vehicles.get(i) instanceof Car){

                if(vehicles.get(i).getType() == VehicleType.NEW) {
                    reportNew += vehicles.get(i).toString() + "\n";
                }else {
                    reportUsed += vehicles.get(i).toString() + "\n";
                }
            }
            
        }

        return reportNew + reportUsed;
    }

    /**
     * Method to show the document status of a vehicle.
     * @param id the id of the vehicle.
     * @return the document status of the vehicle.
     */

    public String showDocumentStatus(String id){

        String status = "";
        Vehicle vehicle = findVehicle(id);

        if(vehicle != null) {

            Document SOAT = vehicle.getDocument(0);

            if(SOAT != null) {

                status += "SOAT: \n";
                status += "Code: " + SOAT.getCode() + "\n";
                status += (SOAT.getYear() >= LocalDate.now().getYear()) ? "Valid until: " + SOAT.getYear() + "\n": "Expired since: " + SOAT.getYear() + "\n";

            }else {
                status += "SOAT: Not registered \n";
            }

            status += "\n";

            Document tm = vehicle.getDocument(1);
            System.out.println(tm.getYear());
            status += "Techno Mechanical: \n";
            status += "Code: " + tm.getCode() + "\n";
            status += (tm.getYear() >= LocalDate.now().getYear()) ? "Valid until: " + tm.getYear() + "\n" : "Expired since: " + tm.getYear() + "\n";
            status += "\n";

            Document pc = vehicle.getDocument(2);

            if(pc != null) {
                status += "Property Card: \n";
                status += "Code: " + pc.getCode() + "\n";
            }else {
                status += "Property Card: Not registered \n";
            }

            status += "\n";


        }else {
            status = "Vehicle not found";
        }

        return status;

    }

    /**
     * Method to find a vehicle by id. It returns null if the vehicle is not found.
     * @param id the id of the vehicle.
     * @return the vehicle.
     */

    public Vehicle findVehicle(String id){

        Vehicle vehicle = null;

        for(int i = 0; i < vehicles.size() && vehicle == null; i++){

            if(vehicles.get(i).getId().equals(id)){
                vehicle = vehicles.get(i);
            }
        }

        return vehicle;
    }

    /**
     * Method to show the parking map.
     * @return the parking map.
     */
    public String showParkingMap(){

        return parking.showParkingMap();

    }

    /**
     * Method to validate if the vehicle must be moved to the parking. If the vehicle is used and its model is older than 2015, it must be moved to the parking.
     * @param vehicle the vehicle to be validated.
     * @return whether the vehicle must be moved to the parking or not.
     */

    public boolean isOld(Vehicle vehicle){

        return (vehicle.getType() == VehicleType.USED) &&
                (vehicle.getModel() < 2015);

    }

    /**
     * Method to move the vehicles to the parking. It moves the test vehicles to the parking.
     */
    public void moveToParking(){

        for(int i = 0; i < vehicles.size(); i++){

            if(isOld(vehicles.get(i)))
                parking.add(vehicles.get(i));

        }

    }

    /**
     * Method to generate a parking report in a time range.
     * @param start the start time.
     * @param end the end time.
     * @return the parking report.
     */
    public String oldCarsInRange(int start, int end){

        return parking.oldCarsInRange(start, end);

    }

    /**
     * Method to show the the newest vehicle data.
     * @return the newest vehicle data.
     */

    public String newestVehicle(){

        Vehicle newest = null;
        int newestModel = 0;

        for(int i = 0; i < vehicles.size(); i++){

            if(vehicles.get(i).getModel() > newestModel){
                newest = vehicles.get(i);
                newestModel = vehicles.get(i).getModel();
            }
        }

        return newest.toString();

    }

    /** 
     * Method to show the oldest vehicle data.
     * @return the oldest vehicle data.
    */

    public String oldestVehicle(){

        Vehicle oldest = null;
        int oldestModel = 0;

        for(int i = 0; i < vehicles.size(); i++){

            if(i == 0 || vehicles.get(i).getModel() < oldestModel){
                oldest = vehicles.get(i);
                oldestModel = vehicles.get(i).getModel();
            }
        }

        return oldest.toString();


    }

    /**
     * Method to show the percentage of parking occupancy. 
     * @return the percentage of parking occupancy.
     */

    public double parkingOccupancyPercentage(){

        return parking.parkingOccupancyPercentage();

    }

}




